package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.exception.GlobalException;
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

    @Override
    public void deleteById(long id) {
        //判断id是否存在
        QueryWrapper<News> deleteQueryWrapper = new QueryWrapper<>();
        deleteQueryWrapper.lambda().eq(News::getNewsId, id);
        News oneId = newsMapper.selectOne(deleteQueryWrapper);
        if (oneId == null) {
            throw new GlobalException(CodeMsg.NEWS_NOT_EXIST);
        } else newsMapper.deleteById(id);
    }

    @Override
    public void updateById(long id) {
        //判断id是否存在
        QueryWrapper<News> updateQueryWrapper = new QueryWrapper<>();
        updateQueryWrapper.lambda().eq(News::getNewsId, id);
        News updateId = newsMapper.selectOne(updateQueryWrapper);
        if (updateId == null) {
            throw new GlobalException(CodeMsg.NEWS_NOT_EXIST);
        } else newsMapper.updateById(updateId);
    }

    @Override
    public void insertById(News news) {
        //插入的新闻
        newsMapper.insert(news);
    }
}
