package com.siyi.controller;

import com.siyi.domain.Admin;
import com.siyi.domain.ReaderInfo;
import com.siyi.domain.Result;
import com.siyi.service.AdminService;
import com.siyi.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderInfoService readerInfoService;

    @RequestMapping(path = "/login")
    @ResponseBody
    public Object login(String username, String password, HttpSession session){
        Result result = new Result();
        Admin admin = adminService.checkLogin(username,password);
        if(admin != null){
            session.setAttribute("user",admin);
            result.setSuccess(true);
            result.setData("admin");
        }else{
            ReaderInfo readerInfo = readerInfoService.checkLogin(username,password);
            if(readerInfo != null){
                session.setAttribute("user",readerInfo);
                result.setSuccess(true);
                result.setData("reader");
            }else{
                result.setSuccess(false);
            }
        }
        System.out.println(result.getSuccess());
        return result;
    }

    @RequestMapping("index")
    public String index(){
        return "index.html";
    }
}
