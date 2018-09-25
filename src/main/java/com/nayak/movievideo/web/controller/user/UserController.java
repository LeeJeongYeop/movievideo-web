package com.nayak.movievideo.web.controller.user;

import com.nayak.movievideo.domain.user.User;
import com.nayak.movievideo.service.user.UserService;
import com.nayak.movievideo.utils.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nayak on 25/09/2018.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/sign-up", method = RequestMethod.GET)
    public String signUp() {
        return "user/sign_up";
    }

    @RequestMapping(path = "/sign-up", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse signUpUser(@RequestBody User user) {
        if (userService.isAlreadyUserId(user.getUserId())) {
            return AjaxResponse.AjaxResponseBuilder.create(AjaxResponse.AjaxResponseCode.FAIL)
                    .setMessage("아이디가 존재합니다.")
                    .build();
        }

        User saveUser = userService.saveUser(user);
        return AjaxResponse.AjaxResponseBuilder.create(AjaxResponse.AjaxResponseCode.SUCCESS)
                .setData(saveUser)
                .build();
    }

    @RequestMapping(path = "/sign-in", method = RequestMethod.GET)
    public String signIn() {
        return "user/sign_in";
    }
}
