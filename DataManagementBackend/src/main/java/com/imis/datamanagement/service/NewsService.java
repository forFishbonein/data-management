package com.imis.datamanagement.service;

import com.imis.datamanagement.domain.News;

import java.awt.*;

public interface NewsService {
    Void getById(long id);
    List<News> getAllNews();

}
