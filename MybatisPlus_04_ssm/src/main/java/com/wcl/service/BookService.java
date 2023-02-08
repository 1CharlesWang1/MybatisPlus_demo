package com.wcl.service;

import com.wcl.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {

    public boolean insert(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book selectById(Integer id);

    public List<Book> selectAll();

    public List<Book> selectByCondition(String name);

    public void selectByPages();
}
