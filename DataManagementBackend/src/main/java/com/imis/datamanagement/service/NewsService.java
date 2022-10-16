package com.imis.datamanagement.service;


import com.imis.datamanagement.domain.News;
import java.util.List;

public interface NewsService  {
 void getById(long id);
 List<News> getAllNews();
}
