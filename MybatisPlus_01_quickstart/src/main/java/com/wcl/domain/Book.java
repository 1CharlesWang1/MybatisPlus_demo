package com.wcl.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("books") // 表名必填
public class Book {
    private int id;
    private String name;
    private int price;

    public Book() {
    }

    public Book(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Book{id = " + id + ", name = " + name + ", price = " + price + "}";
    }
}
