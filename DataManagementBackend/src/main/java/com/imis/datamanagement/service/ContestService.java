package com.imis.datamanagement.service;

import com.imis.datamanagement.domain.Contest;
import com.imis.datamanagement.domain.News;

import java.util.List;

public interface ContestService {
    Contest getById(long id);
    List<Contest> getAllContest();
    void deleteById(long id);
    void updateById(long id);
    void insert(Contest contest);

}
