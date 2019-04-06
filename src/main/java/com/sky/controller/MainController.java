package com.sky.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/skylogin")
    public String log(Model model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!ObjectUtils.isEmpty(object) && object instanceof UserDetails) {
            UserDetails user = (UserDetails) object;
            String username = user.getUsername();
            model.addAttribute("username", username);
            return "redirect:/product/index";
        }
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
