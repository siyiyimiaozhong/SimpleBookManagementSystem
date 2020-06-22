package com.siyi.controller;

import com.siyi.domain.Admin;
import com.siyi.domain.ReaderInfo;
import com.siyi.vo.Result;
import com.siyi.service.AdminService;
import com.siyi.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("updatePW")
    @ResponseBody
    public Result updatePW(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            HttpSession session
    ){
        Result result = new Result();
        Object user = session.getAttribute("user");
        Integer i=null;
        if(user instanceof Admin){
            System.out.println((Admin)user);
            Long id = ((Admin) user).getAdminId();
            i = adminService.updatePW(id,oldPassword,newPassword);
        }else{
            Long id = ((ReaderInfo) user).getReaderId();
            i = readerInfoService.updatePW(id,oldPassword,newPassword);
        }
        if(i==1){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
