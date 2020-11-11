package com.hero.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: BookController
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/home")
    public String home() {
        System.out.println("/book/home url invoked");
        return "book home";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") String id) {
        System.out.println("/book/show url invoked");
        return "book" + id;
    }
}
