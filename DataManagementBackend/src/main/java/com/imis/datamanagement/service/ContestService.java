package com.imis.datamanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.datamanagement.domain.Contest;

import java.util.List;

public interface ContestService extends IService<Contest> {

    Contest getById(long id);

    List<Contest> getAllContest();

    void deleteById(long id);

    void update(Contest contest);

    void insert(Contest contest);

}
