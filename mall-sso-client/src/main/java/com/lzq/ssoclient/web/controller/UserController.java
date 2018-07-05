package com.lzq.ssoclient.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lizhuquan on 2018/7/5.
 */
@RestController
@RequestMapping("/me")
public class UserController {

    @GetMapping
    public Principal user(Principal user) {
        return user;
    }
}
