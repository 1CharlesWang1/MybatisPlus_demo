package com.wcl.controller;

import com.wcl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wcl.domain.Book;

import java.util.List;

/**
 * REST风格开发
 */

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result insert(@RequestBody Book book) {
        boolean flag = bookService.insert(book);
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Book book = bookService.selectById(id);
        Integer code = book != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = book != null ? "" : "数据查询失败";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        Integer code = books != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = books != null ? "" : "数据查询失败";
        return new Result(code, books, msg);
    }

    @PutMapping("/{name}")
    public Result selectByCondition(@PathVariable String name) {
        List<Book> books = bookService.selectByCondition(name);
        Integer code = books != null ? Code.SELECT_OK : Code.SELECT_ERR;
        String msg = books != null ? "" : "数据查询失败";
        return new Result(code, books, msg);
    }

}



