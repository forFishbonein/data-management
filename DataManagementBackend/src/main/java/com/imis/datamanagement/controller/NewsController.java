package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

    @Resource
    NewsService newsService;

    @GetMapping("/{newsId}")
    public Result<News> getByNewsId(@PathVariable("newsId") Long newsId){
        News news = newsService.getById(newsId);
        if (news == null) {
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        return Result.success(news);
    }
    @GetMapping
    public Result<List<News>> getByAllNewsId(){
        List<News> news = newsService.getAllNews();
        if (news == null) {
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        return Result.success(news);
    }
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable("id") Long id){
     newsService.deleteById(id);
    }
    @GetMapping ("/{update}")
    public void updateNews(@PathVariable("id") Long id){
        newsService.updateById(id);
    }
    @GetMapping("/{insert}")
    public void insertNews(@PathVariable("id") News id){
        newsService.insertById(id);
    }
}
