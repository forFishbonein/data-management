package com.imis.datamanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imis.datamanagement.domain.Contest;
import com.imis.datamanagement.domain.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContestMapper extends BaseMapper<Contest> {
}
