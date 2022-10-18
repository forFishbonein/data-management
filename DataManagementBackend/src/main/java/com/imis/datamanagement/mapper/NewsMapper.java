package com.imis.datamanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imis.datamanagement.domain.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
