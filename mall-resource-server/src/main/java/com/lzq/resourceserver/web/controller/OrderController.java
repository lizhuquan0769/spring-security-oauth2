package com.lzq.resourceserver.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhuquan on 2018/7/3.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{id}")
    public String get(@PathVariable String id) {
        return "order id: " + id;
    }
}

