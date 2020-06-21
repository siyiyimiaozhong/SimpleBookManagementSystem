package com.siyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {
    @RequestMapping("admin_main")
    public String main(){
        return "admin_main.html";
    }

    @RequestMapping("admin_book_show")
    public String boo_show(){
        return "admin_book_show.html";
    }

    @RequestMapping("admin_book")
    public String adminBookAdd(){
        return "admin_book.html";
    }
}
