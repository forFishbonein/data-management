package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.mapper.NewsMapper;
import com.imis.datamanagement.service.NewsService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Resource
    NewsMapper newsMapper;

    @Override
    public News getById(long id) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(News::getNewsId, id);
        News oneNews = newsMapper.selectOne(queryWrapper);
        return oneNews;
    }

    @Override
    public List<News> getAllNews() {
        QueryWrapper<News> newsQueryWrapper = new QueryWrapper<>();
        newsQueryWrapper.isNull("newId");
        List<News> allNews = newsMapper.selectList(newsQueryWrapper);
        return allNews;
    }
}
