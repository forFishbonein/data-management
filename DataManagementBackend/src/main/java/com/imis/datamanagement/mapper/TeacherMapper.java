package com.imis.datamanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imis.datamanagement.common.vo.ShowVo;
import com.imis.datamanagement.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    ShowVo getByTeacherId (@Param("id") Long id);

    List<ShowVo> getAll();
}
