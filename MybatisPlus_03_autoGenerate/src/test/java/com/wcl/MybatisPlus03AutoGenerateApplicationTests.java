package com.wcl;

import com.wcl.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlus03AutoGenerateApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelect() {
        System.out.println(bookDao.selectById(1));
    }

}
