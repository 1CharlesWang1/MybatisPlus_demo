package com.wcl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wcl.domain.Book;
import com.wcl.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus04SsmApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void selectAllTest() {
        List<Book> books = bookService.selectAll();
        System.out.println(books);
    }


}
