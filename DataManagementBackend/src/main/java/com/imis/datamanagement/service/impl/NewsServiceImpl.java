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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        newsQueryWrapper.isNotNull("news_id");
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
        }
        newsMapper.deleteById(id);
    }

    @Override
    public void update(News news) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(News::getNewsId, news.getNewsId());
        News newsInMysql = newsMapper.selectOne(queryWrapper);
        if (newsInMysql == null) {
            throw new GlobalException(CodeMsg.NEWS_NOT_EXIST);
        }
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        news.setUpdateTime(dateFormat.format(date));
        newsMapper.update(news, queryWrapper);
    }

    @Override
    public void insert(News news) {
        //插入的新闻
        newsMapper.insert(news);
    }
}
