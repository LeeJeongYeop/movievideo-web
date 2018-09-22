package com.nayak.movievideo.web.controller;

import com.nayak.movievideo.domain.Movie;
import com.nayak.movievideo.domain.MovieRepository;
import com.nayak.movievideo.domain.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nayak on 2018. 6. 6..
 */
@Controller
@RequestMapping("/")
public class MovieController {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final MovieRepository movieRepository;

    private final VideoRepository videoRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, VideoRepository videoRepository) {
        this.movieRepository = movieRepository;
        this.videoRepository = videoRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String moveList(Model model) {
        List<Movie> movieList = movieRepository.findMovieByCrawlingDate(DATE_FORMAT.format(new Date()));
        movieList.forEach(movie -> movie.setVideoList(videoRepository.findVideoByMovieTitle(movie.getMovieTitle())));
        model.addAttribute("movieList", movieList);
        return "movie/movie_list";
    }
}
