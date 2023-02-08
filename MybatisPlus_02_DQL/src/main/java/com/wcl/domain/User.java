package com.wcl.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("users") // 表名必填
public class User {

//  自建长整型 id 用于创建不重复 id
//  @TableId(type = IdType.ASSIGN_ID)
    private long id;
    private String username;
    @TableField(value = "password", select = false)  //表名与是否显示
    private String password;
    private int age;
    private String gender;
//    @TableLogic(value = "0",delval = "1")
    private int deleted;
    @TableField(exist = false)
    private Integer online;
    @Version
    private int version;
}
