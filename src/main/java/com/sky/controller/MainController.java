package com.sky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/skylogin")
    public String log() {
        return "login";
    }

    @RequestMapping("/403")
    public String error() {
        return "error";
    }

    @RequestMapping("/imageCode")
    public String imageCode() {
        return "imageCode";
    }
}
