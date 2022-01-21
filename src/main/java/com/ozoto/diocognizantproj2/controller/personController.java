package com.ozoto.diocognizantproj2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class personController {

    @GetMapping
    public String getTest() {
        return "This is a drill";
    }
}
