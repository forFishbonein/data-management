package com.imis.datamanagement.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.datamanagement.domain.News;

import java.util.List;

public interface NewsService extends IService<News> {

    News getById(long id);

    List<News> getAllNews();

    void deleteById(long id);

    void update(News news);

    void insert(News news);
}
