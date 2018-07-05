package com.lzq.authorizationserver.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhuquan on 2018/7/5.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "hello authorization server";
    }
}
