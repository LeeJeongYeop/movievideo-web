package com.nayak.movievideo.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nayak on 25/09/2018.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/sign-up", method = RequestMethod.GET)
    public String signUp() {
        return "user/sign_up";
    }

    @RequestMapping(path = "/sign-in", method = RequestMethod.GET)
    public String signIn() {
        return "user/sign_in";
    }
}
