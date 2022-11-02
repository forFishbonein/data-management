package com.imis.datamanagement.controller;

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.common.result.Result;
import com.imis.datamanagement.domain.Experience;
import com.imis.datamanagement.service.ExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/experience")
@Slf4j
public class ExperienceController {


    final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    //根据id查询一条信息
    @GetMapping("/{ExperienceId}")
    public Result<Experience> getById(@PathVariable("ExperienceId") Long ExperienceId) {
        Experience experience = experienceService.getById(ExperienceId);
        if (experience == null) {
            return Result.error(CodeMsg.Experience_NOT_EXIST);
        }
        return Result.success(experience);
    }

    //查询某个竞赛的全部信息
    @GetMapping("/contest/{ContestId}")
    public Result<List<Experience>> getAllExperience(@PathVariable("ContestId") Long ContestId) {
        List<Experience> experience = experienceService.getAll(ContestId);
        return Result.success(experience);
    }

    //增加一条竞赛信息
    @PutMapping
    public Result<String> insert(@RequestBody Experience experience) {
        experienceService.insert(experience);
        return Result.success("新增成功");
    }

    //根据id删除
    @DeleteMapping("/{experienceId}")
    public Result<String> deleteById(@PathVariable("experienceId") Long experienceId) {
        experienceService.deleteById(experienceId);
        return Result.success("删除成功");
    }

    //更新竞赛信息
    @PostMapping
    public Result<String> update(@RequestBody Experience experience) {
        experienceService.update(experience);
        return Result.success("修改成功");
    }
}

