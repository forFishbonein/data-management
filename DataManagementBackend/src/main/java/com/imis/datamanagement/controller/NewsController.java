package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

    @Resource
    NewsService newsService;

    @GetMapping("/{newSId}")
    public Result<News> getByNewsId(@PathVariable("newsId") Long newsId){
        News news = newsService.getById(newsId);
        if (news == null) {
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        return Result.success(news);
    }

}
