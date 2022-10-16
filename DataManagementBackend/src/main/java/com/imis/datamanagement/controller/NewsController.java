package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.service.NewsService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
//   @GetMapping("/all")
//    public Result<News> getAll(){
//        News news = newsService.getAllNews();
//        return Result.success(news);
//   }
//    @PostMapping("")
}
