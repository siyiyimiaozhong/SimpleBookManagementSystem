package com.siyi.controller;

import com.siyi.domain.BookInfo;
import com.siyi.domain.BookType;
import com.siyi.service.BookInfoService;
import com.siyi.service.BookTypeService;
import com.siyi.vo.PageResult;
import com.siyi.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("page")
    public ResponseEntity<PageResult<BookInfo>> queryByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "10") Integer rows
    ){
        PageResult<BookInfo> result = bookInfoService.findAll(key,page,rows);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping("show")
    public ResponseEntity<BookInfo> bookShow(@RequestParam("id") Long id){
        BookInfo book = bookInfoService.findBookById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @RequestMapping("type")
    public ResponseEntity<List<BookType>> findAllBookType(){
        List<BookType> types = bookTypeService.findAll();
        if(types == null || CollectionUtils.isEmpty(types)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(types);
    }

    @RequestMapping("addBook")
    @ResponseBody
    public Result addBook(BookInfo book){
        Result result = new Result();
        int i = bookInfoService.addBook(book);
        if(i!=1){
            result.setSuccess(false);
        }else{
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("updateBook")
    @ResponseBody
    public Result updateBook(BookInfo book){
        Result result = new Result();
        int i = bookInfoService.updateBook(book);
        if(i!=1){
            result.setSuccess(false);
        }else{
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("deleteBook")
    @ResponseBody
    public Result deleteBook(@RequestParam("id") Long id){
        Result result = new Result();
        int i = bookInfoService.deleteById(id);
        if(i!=1){
            result.setSuccess(false);
        }else{
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("deleteBooks")
    @ResponseBody
    public Result deleteBooksByIds(@RequestParam("ids") String ids){
        String[] idArray = ids.split(",");
        Result result = new Result();
        boolean flag = bookInfoService.deleteByIdArray(idArray);
        if(flag){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
