package com.siyi.controller;

import com.siyi.domain.BookInfo;
import com.siyi.domain.ReaderInfo;
import com.siyi.vo.PageResult;
import com.siyi.vo.Result;
import com.siyi.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("reader")
public class ReaderController {
    @Autowired
    private ReaderInfoService readerInfoService;

    @RequestMapping("addReader")
    @ResponseBody
    public Object addReader(ReaderInfo readerInfo){
        if(readerInfo.getPassword()==null){
            readerInfo.setPassword("123456");
        }
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

    @RequestMapping("page")
    public ResponseEntity<PageResult<ReaderInfo>> page(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows
    ){
        PageResult<ReaderInfo> result = readerInfoService.findAll(key,page,rows);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("updateReader")
    @ResponseBody
    public Result updateBook(ReaderInfo readerInfo){
        Result result = new Result();
        int i = readerInfoService.updateReader(readerInfo);
        if(i!=1){
            result.setSuccess(false);
        }else{
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("findReaderById")
    public ResponseEntity<ReaderInfo> bookShow(@RequestParam("id") Long id){
        ReaderInfo reader = readerInfoService.findReaderById(id);
        if(reader == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reader);
    }

    @RequestMapping("deleteReader")
    @ResponseBody
    public Result deleteBook(@RequestParam("id") Long id){
        Result result = new Result();
        int i = readerInfoService.deleteReaderById(id);
        if(i==1){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("deleteReaders")
    @ResponseBody
    public Result deleteReaders(@RequestParam("ids") String ids){
        Result result = new Result();
        boolean flag = readerInfoService.deleteReaders(ids.split(","));
        if(flag){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
