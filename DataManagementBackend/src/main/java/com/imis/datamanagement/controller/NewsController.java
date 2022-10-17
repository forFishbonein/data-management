package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.News;
import com.imis.datamanagement.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {

    @Resource
    NewsService newsService;

    //根据id查询
    @GetMapping("/{newsId}")
    public Result<News> getById(@PathVariable("newsId") Long newsId){
        News news = newsService.getById(newsId);
        if (news == null) {
            return Result.error(CodeMsg.NEWS_NOT_EXIST);
        }
        return Result.success(news);
    }

    //查询全部
    @GetMapping
    public Result<List<News>> getAllNews(){
        List<News> news = newsService.getAllNews();
          return Result.success(news);
    }

    //增加一条新闻
      @PostMapping("/insert")
     public Result<String> insert(@RequestBody News news){
        newsService.insert(news);
        return Result.success("新增成功");
      }

      //根据id删除
      @DeleteMapping("/delete/{newsId}")
       public Result<String> deleteById(@PathVariable("newsId") Long newsId){
        newsService.deleteById(newsId);
         return Result.success("删除成功");
      }

      //根据id修改
      @PutMapping("/update/{newsId}")
         public Result<String> updateById(@PathVariable("newsId") Long newsId){
          newsService.updateById(newsId);
          return Result.success("修改成功");
      }
}
