package com.nayak.movievideo.web.controller;

import com.nayak.movievideo.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nayak on 2018. 6. 6..
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String moveList(Model model) {
        model.addAttribute("movieList", movieRepository.findMovieByCrawlingDate(DATE_FORMAT.format(new Date())));
        return "movie/movie_list";
    }
}
