package com.lzq.authorizationserver.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by lizhuquan on 2018/7/3.
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request, Principal user) {
        return user;
    }
}
