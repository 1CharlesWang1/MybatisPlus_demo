package com.wcl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcl.dao.UserDao;
import com.wcl.domain.User;
import com.wcl.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void selectAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }


    /**
     * 分页查询,需要设置拦截器
     */
    @Test
    void selectByPages() {
        IPage page = new Page(1, 2);
        userDao.selectPage(page, null);
        System.out.println("当前页码值: " + page.getCurrent());
        System.out.println("每页显示数: " + page.getSize());
        System.out.println("一共多少页: " + page.getPages());
        System.out.println("一共多少条数据: " + page.getTotal());
        System.out.println("数据: " + page.getRecords());
    }

    /**
     * 条件查询
     */
    // lambda 格式查询
    @Test
    void selectByAgeCondition() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        // 10到 30岁之间
//		lqw.lt(User::getAge,30).gt(User::getAge,10);
//		List<User> users = userDao.selectList(lqw);

        //大于 40,小于30
        lqw.lt(User::getAge, 30).or().gt(User::getAge, 40);
        List<User> users = userDao.selectList(lqw);

        System.out.println(users);
    }

    // 查询投影
    @Test
    void selectGroupByCondition() {
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count ,gender");
        lqw.groupBy("gender");
        List<Map<String,Object>> users = userDao.selectMaps(lqw);
        System.out.println(users);
    }

    @Test
    void selectByEqualCondition() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //等于
        lqw.eq(User::getUsername,"wcl").eq(User::getPassword,"123");
        //模糊
//        lqw.like(User::getUsername,"c");
        User loginUser = userDao.selectOne(lqw);
        System.out.println(loginUser);
    }

    @Test
    void selectByScopeCondition() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //范围
         lqw.between(User::getAge,20,40);

        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }

    @Test
    // 逻辑删除,数据不能访问但还保留
    void Delete(){
        userDao.deleteById(4);
    }

    @Test
    //删除多条
    void DeleteLists(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        userDao.deleteBatchIds(list);
    }


    /**
     * 设置乐观锁
     */
    @Test
    //删除多条
    void updateTest(){
        User user = userDao.selectById(3);
        User user2 = userDao.selectById(3);

        user.setUsername("cyb 666");
        userDao.updateById(user);

        user2.setUsername("cyb 777");
        userDao.updateById(user2);
    }

}
