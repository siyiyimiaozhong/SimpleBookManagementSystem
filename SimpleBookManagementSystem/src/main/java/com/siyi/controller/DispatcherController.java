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

    @RequestMapping("admin_book_type")
    public String adminBookType(){
        return "admin_book_type.html";
    }

    @RequestMapping("adminBookTypeAdd")
    public String adminBookTypeAdd(){
        return "admin_book_type_add.html";
    }

    @RequestMapping("adminAllReader")
    public String adminAllReader(){
        return "admin_all_reader.html";
    }

    @RequestMapping("adminReader")
    public String adminReader(){
        return "admin_reader.html";
    }

    @RequestMapping("adminOverdue")
    public String adminOverdue(){
        return "admin_overdue.html";
    }

    @RequestMapping("adminNotReturn")
    public String adminNotReturn(){
        return "admin_not_return.html";
    }

    @RequestMapping("adminBorrow")
    public String adminBorrow(){
        return "admin_borrow.html";
    }

    @RequestMapping("changePassword")
    public String changePassword(){
        return "change_password.html";
    }

    @RequestMapping("header")
    public String header(){
        return "header.html";
    }

    @RequestMapping("adminAside")
    public String aside(){
        return "admin_aside.html";
    }

    @RequestMapping("readerAside")
    public String readerAside(){
        return "reader_aside.html";
    }

    @RequestMapping("reader_main")
    public String reader_main(){
        return "reader_search_book.html";
    }
}
