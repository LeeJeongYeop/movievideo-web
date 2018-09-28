package com.nayak.movievideo.web.controller.user;

import com.nayak.movievideo.domain.user.User;
import com.nayak.movievideo.web.service.user.UserService;
import com.nayak.movievideo.utils.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    public String signUp(Principal principal) {
        return null == principal ? "user/sign_up" : "redirect:/";
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

    @RequestMapping(path = "/sign-in")
    public String signIn(HttpServletRequest request, Principal principal) {
        request.getSession().setAttribute("prevPage", request.getHeader("Referer"));
        return null == principal ? "user/sign_in" : "redirect:/";
    }

    @RequestMapping(path = "/validation", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse userIdValidation(@RequestParam String userId) {
        return AjaxResponse.AjaxResponseBuilder.create(userService.isAlreadyUserId(userId)).build();
    }
}
