package com.nayak.movievideo.web.controller;

import com.nayak.movievideo.domain.Video;
import com.nayak.movievideo.domain.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

/**
 * Created by nayak on 2018. 6. 9..
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String videoList(@RequestParam String movieTitle, Model model) {
        model.addAttribute("videoList", videoRepository.findVideoByMovieTitle(movieTitle));
        return "video/video_list";
    }

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public String videoDetail(@RequestParam String videoId, Model model) {
        Video video = videoRepository.findVideoByVideoId(videoId);
        model.addAttribute("video", video);
        model.addAttribute("relatedVideoList", videoRepository.findVideoByMovieTitle(video.getMovieTitle()).stream()
                .filter(relatedVideo -> !relatedVideo.getVideoId().equals(video.getVideoId()))
                .collect(Collectors.toList()));
        return "video/video_detail";
    }
}