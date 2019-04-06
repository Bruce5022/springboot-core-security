package com.sky.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product")
public class ProductController {


    /**
     * 商品添加
     */
    @RequestMapping("/index")
    public String index(Model model){
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!ObjectUtils.isEmpty(object) && object instanceof UserDetails) {
            UserDetails user = (UserDetails) object;
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "index";
    }


    /**
     * 商品添加
     */
    @RequestMapping("/add")
    public String add(){
        return "product/productAdd";
    }

    /**
     * 商品修改
     */
    @RequestMapping("/update")
    public String update(){
        return "product/productUpdate";
    }

    /**
     * 商品修改
     */
    @RequestMapping("/list")
    public String list(){
        return "product/productList";
    }

    /**
     * 商品删除
     */
    @RequestMapping("/delete")
    public String delete(){
        return "product/productDelete";
    }


}
