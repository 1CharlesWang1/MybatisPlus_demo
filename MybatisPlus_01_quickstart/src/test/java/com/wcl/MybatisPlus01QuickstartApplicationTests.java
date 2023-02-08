package com.wcl;

import com.wcl.dao.BookDao;
import com.wcl.domain.Book;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus01QuickstartApplicationTests {

	@Autowired
	private BookDao bookDao;

	@Test
	void selectAll() {
		List<Book> books = bookDao.selectList(null);
		System.out.println(books);
	}

	@Test
	void insert() {
		Book book =new Book(10,"wcl",100);
		bookDao.insert(book);
	}

	@Test
	void update() {
		Book book = new Book();
		book.setId(10);
		book.setName("wcl");
		book.setPrice(99);
		bookDao.updateById(book);
	}

	@Test
	void delete() {
		bookDao.deleteById(10);
	}

	@Test
	void selectById() {
		Book book = bookDao.selectById(1);
		System.out.println(book);
	}

}
