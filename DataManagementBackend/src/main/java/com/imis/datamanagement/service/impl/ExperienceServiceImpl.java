package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.domain.Contest;
import com.imis.datamanagement.domain.Experience;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.ExperienceMapper;
import com.imis.datamanagement.service.ExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper,Experience> implements ExperienceService {
    @Resource
    ExperienceMapper experienceMapper;

    //插入一条竞赛的经验
    @Override
    public void insert(Experience experience) {
        experienceMapper.insert(experience);
    }

    //删除一条竞赛的经验
    @Override
    public void deleteById(long experience_id) {
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Experience::getExperienceId,experience_id);
        Experience experience = experienceMapper.selectOne(wrapper);
        experienceMapper.deleteById(experience_id);
    }
    //更新一条竞赛经验
    @Override
    public void update(Experience experience) {
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Experience::getExperienceId,experience.getExperienceId());
        Experience ex = experienceMapper.selectOne(wrapper);
        if (ex == null) {
            throw new GlobalException(CodeMsg.Experience_NOT_EXIST);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        experience.setUpdateTime(dateFormat.format(date));
        experienceMapper.update(experience,wrapper);
    }
    //查找某个竞赛的全部信息
    @Override
    public List<Experience> getAll(long experience_id) {
        List<Experience> experiences = experienceMapper.selectJoinList(Experience.class,
                                    new MPJLambdaWrapper<Experience>()
                                            .selectAll(Experience.class)
                                            .leftJoin(Contest.class,Contest::getContestId,Experience::getContestId)
                                            .eq(Experience::getContestId,experience_id));
        return experiences;
    }

    //查询一条竞赛的信息
    @Override
    public Experience getById(long experience_id) {
        QueryWrapper<Experience> experience = new QueryWrapper<>();
        experience.lambda().eq(Experience::getExperienceId,experience_id);
        Experience ex = experienceMapper.selectOne(experience);
        return ex;
    }




}
