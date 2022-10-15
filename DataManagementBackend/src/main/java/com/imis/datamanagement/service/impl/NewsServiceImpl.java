package com.imis.datamanagement.service.impl;

import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.mapper.NewsMapper;
import com.imis.datamanagement.service.NewsService;


import javax.annotation.Resource;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Resource
    NewsMapper newsMapper;
    @Override
    public void getById(long id) {

    }

    @Override
    public List<News> getAllNews() {
return null;
    }
}
