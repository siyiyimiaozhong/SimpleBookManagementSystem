package com.siyi.controller;

import com.siyi.domain.ReaderInfo;
import com.siyi.vo.Result;
import com.siyi.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("reader")
public class ReaderController {
    @Autowired
    private ReaderInfoService readerInfoService;

    @RequestMapping("addReader")
    @ResponseBody
    public Object addReader(ReaderInfo readerInfo){
        Result result = new Result();
        System.out.println(readerInfo);
        boolean flag = readerInfoService.addReader(readerInfo);
        if(flag){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
