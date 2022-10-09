package com.imis.datamanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imis.datamanagement.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
