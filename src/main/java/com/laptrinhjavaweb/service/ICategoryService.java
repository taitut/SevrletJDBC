package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.Category;

public interface ICategoryService {
    List<Category> findAll();

    Category save(Category category);

    Category update(Category category);

    void delete(Long[] ids);
}
