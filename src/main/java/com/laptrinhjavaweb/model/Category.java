package com.laptrinhjavaweb.model;


;


public class Category extends abstractnodel<Category> {


    private Long news;
    private String name;
    private String code;

    public Category() {
    }

    public Category(Long news) {
        this.news = news;
    }


    public Long getLong() {
        return this.news;
    }

    public void setLong(Long news) {
        this.news = news;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
