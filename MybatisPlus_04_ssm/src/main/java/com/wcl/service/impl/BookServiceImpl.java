package com.wcl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcl.dao.BookDao;
import com.wcl.domain.Book;
import com.wcl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean insert(Book book) {
        bookDao.insert(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        bookDao.updateById(book);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        bookDao.deleteById(id);
        return true;
    }

    @Override
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public List<Book> selectByCondition(String name) {
            LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
            //模糊
            lqw.like(Book::getName,name);
            List<Book> users = bookDao.selectList(lqw);
            return users;
    }

    @Override
    public void selectByPages() {
        IPage page = new Page(1, 2);
        bookDao.selectPage(page, null);
        System.out.println("当前页码值: " + page.getCurrent());
        System.out.println("每页显示数: " + page.getSize());
        System.out.println("一共多少页: " + page.getPages());
        System.out.println("一共多少条数据: " + page.getTotal());
        System.out.println("数据: " + page.getRecords());
    }
}
