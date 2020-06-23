package com.siyi.controller;

import com.siyi.domain.BookInfo;
import com.siyi.domain.Borrow;
import com.siyi.domain.ReaderInfo;
import com.siyi.service.BookInfoService;
import com.siyi.service.BorrowService;
import com.siyi.vo.PageResult;
import com.siyi.vo.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BookInfoService bookInfoService;

    @RequestMapping("overdue")
    public ResponseEntity<List<Borrow>> overdue(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "value",required = false) String value
    ){
        List<Borrow> borrows = borrowService.findAllByOverdue(key,value);
        if(borrows==null || borrows.size()==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(borrows);
    }

    @RequestMapping("updateBackDate")
    @ResponseBody
    public Result updateBackDate(@RequestParam("id") String id){
        Result result=new Result();
        int i = borrowService.updateBackDate(id);
        if(i!=1){
            result.setSuccess(false);
        }else{
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("updateBackDateByIds")
    @ResponseBody
    public Result updateBackDateByIds(@RequestParam("ids") String ids){
        Result result=new Result();
        String[] idArray = ids.split(",");
        if(borrowService.updateBackDateByIds(idArray)){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("pageNotReturn")
    public ResponseEntity<PageResult<Borrow>> pageNotReturn(
        @RequestParam(value = "page",defaultValue = "1") Integer page,
        @RequestParam(value = "rows",defaultValue = "10") Integer rows,
        @RequestParam(value = "key",required = false) String key,
        @RequestParam(value = "value",required = false) String value
    ){
        PageResult<Borrow> result = borrowService.findAllByNotReturn(key,value,page,rows);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("page")
    public ResponseEntity<PageResult<Borrow>> page(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows,
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "value",required = false) String value
    ){
        PageResult<Borrow> result = borrowService.findAll(key,value,page,rows);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("borrow")
    @ResponseBody
    public Result borrow(@RequestParam("id") Long id, HttpSession session){
        Result result = new Result();
        ReaderInfo reader = (ReaderInfo)session.getAttribute("user");
        int i = borrowService.saveBorrow(id,reader.getReaderId());
        i += bookInfoService.borrow(id);
        if(i==2){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("borrowBooks")
    @ResponseBody
    public Result borrowBooks(@RequestParam("ids") String ids, HttpSession session){
        Result result = new Result();
        ReaderInfo reader = (ReaderInfo)session.getAttribute("user");
        String[] idArray = ids.split(",");
        for(String id:idArray){
            int i = borrowService.saveBorrow(Long.parseLong(id),reader.getReaderId());
            i += bookInfoService.borrow(Long.parseLong(id));
            if(i==2){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
                return result;
            }
        }
        return result;
    }

    @RequestMapping("pageByMyBorrow")
    public ResponseEntity<PageResult<Borrow>> pageByMyBorrow(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows,
            @RequestParam(value = "key",required = false) String key,
            HttpSession session
    ){
        ReaderInfo reader = (ReaderInfo) session.getAttribute("user");
        PageResult<Borrow> result = borrowService.findAllByUserId(reader.getReaderId(),key,page,rows);
        System.out.println(result);
        System.out.println(result.getItems());
        System.out.println(result.getItems().get(0));
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
