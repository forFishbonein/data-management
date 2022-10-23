package com.imis.datamanagement.service;

import com.imis.datamanagement.domain.Experience;

import java.util.List;

public interface ExperienceService {
void insert(Experience experience);

void deleteById(long experience_id);

void update(Experience experience);

List<Experience> getAll(long experience_id);

Experience getById(long experience_id);

}
