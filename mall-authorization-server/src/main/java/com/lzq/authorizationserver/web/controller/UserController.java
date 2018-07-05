package com.lzq.authorizationserver.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lizhuquan on 2018/7/5.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("/me")
    public Principal me(Principal principal) {
        return principal;
    }

}
