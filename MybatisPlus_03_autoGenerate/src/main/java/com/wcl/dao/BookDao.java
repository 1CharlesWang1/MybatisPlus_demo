package com.wcl.dao;

import com.wcl.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Charles
 * @since 2023-02-08
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
