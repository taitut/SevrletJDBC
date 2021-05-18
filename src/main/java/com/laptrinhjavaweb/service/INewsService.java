package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.Pageble.Pageble;
import com.laptrinhjavaweb.model.News;

public interface INewsService {
    List<News> findByCategoryId(Long categoryId);

    News save(News news);

    News update(News news);

    void delete(Long[] ids);

    News findOne(Long id);

    List<News> findAllNews(Pageble pageble);

    List<News> findNBy(String filed, Object... objects);

    int getTotalItem();
}
