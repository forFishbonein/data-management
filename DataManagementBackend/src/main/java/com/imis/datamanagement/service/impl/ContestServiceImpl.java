package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.domain.Contest;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.mapper.ContestMapper;
import com.imis.datamanagement.service.ContestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ContestServiceImpl extends ServiceImpl<ContestMapper, Contest> implements ContestService {

    @Resource
    ContestMapper contestMapper;

    @Override
    public Contest getById(long id) {
        QueryWrapper<Contest> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Contest::getContestId, id);
        Contest oneContest = contestMapper.selectOne(queryWrapper);
        return oneContest;
    }

    @Override
    public List<Contest> getAllContest() {
        QueryWrapper<Contest> contestQueryWrapper = new QueryWrapper<>();
        contestQueryWrapper.isNotNull("contest_id");
        List<Contest> allContest = contestMapper.selectList(contestQueryWrapper);
        return allContest;
    }

    @Override
    public void deleteById(long id) {
        //判断id是否存在
        QueryWrapper<Contest> deleteQueryWrapper = new QueryWrapper<>();
        deleteQueryWrapper.lambda().eq(Contest::getContestId,id);
        Contest oneId = contestMapper.selectOne(deleteQueryWrapper);
        if (oneId == null) {
            throw new GlobalException(CodeMsg.CONTEST_NOT_EXIST);
        } else  contestMapper.deleteById(id);
    }

    @Override
    public void updateById(long id) {
        //判断id是否存在
        QueryWrapper<Contest> updateQueryWrapper = new QueryWrapper<>();
        updateQueryWrapper.lambda().eq(Contest::getContestId, id);
        Contest updateId = contestMapper.selectOne(updateQueryWrapper);
        if (updateId == null) {
            throw new GlobalException(CodeMsg.CONTEST_NOT_EXIST);
        } else contestMapper.updateById(updateId);
    }

    @Override
    public void insert(Contest contest) {
        //新增竞赛
        contestMapper.insert(contest);
    }
}



