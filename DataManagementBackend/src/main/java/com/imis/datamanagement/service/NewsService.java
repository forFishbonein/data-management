package com.imis.datamanagement.service;


import com.imis.datamanagement.domain.News;
import java.util.List;

public interface NewsService  {
 News getById(long id);
 List<News> getAllNews();
  void deleteById(long id);
  void updateById(long id);
  void insert(News news);
}
