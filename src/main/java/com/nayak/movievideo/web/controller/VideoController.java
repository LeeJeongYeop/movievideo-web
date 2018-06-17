package com.nayak.movievideo.web.controller;

import com.nayak.movievideo.domain.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nayak on 2018. 6. 9..
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String videoList(@RequestParam String movieTitle, Model model) {
        model.addAttribute("videoList", videoRepository.findVideoByMovieTitle(movieTitle));
        return "video/video_list";
    }
}