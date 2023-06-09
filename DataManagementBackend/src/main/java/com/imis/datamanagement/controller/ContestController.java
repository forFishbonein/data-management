package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.Contest;
import com.imis.datamanagement.service.ContestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/contest")
@Slf4j
public class ContestController {
    final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    //根据id查询
    @GetMapping("/{contestId}")
    public Result<Contest> getById(@PathVariable("contestId") Long contestId){
        Contest contest = contestService.getById(contestId);
        if (contest == null) {
            return Result.error(CodeMsg.CONTEST_NOT_EXIST);
        }
        return Result.success(contest);
    }

    //查询全部
    @GetMapping
    public Result<List<Contest>> getAllNews(){
        List<Contest> contests = contestService.getAllContest();
        return Result.success(contests);
    }

    //增加一条竞赛
    @PutMapping
    public Result<String> insert(@RequestBody Contest contest){
        contestService.insert(contest);
        return Result.success("新增成功");
    }

    //根据id删除
    @DeleteMapping("/{contestId}")
    public Result<String> deleteById(@PathVariable("contestId") Long contestId){
        contestService.deleteById(contestId);
        return Result.success("删除成功");
    }

    //根据id修改
    @PostMapping
    public Result<String> update(@RequestBody Contest contest){
        contestService.update(contest);
        return Result.success("修改成功");
    }

}
