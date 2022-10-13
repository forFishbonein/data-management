package com.imis.datamanagement.service.impl;

import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.mapper.NewsMapper;
import com.imis.datamanagement.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public Void getById(long id) {

    }

    @Override
    public List<News> getAllNews() {

        return  null;
    }
}
