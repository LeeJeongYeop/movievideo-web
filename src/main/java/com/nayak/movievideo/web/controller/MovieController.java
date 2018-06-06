package com.nayak.movievideo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nayak on 2018. 6. 6..
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String moveList() {
        return "movie/movie_list";
    }
}
