package com.imis.datamanagement.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.datamanagement.domain.User;

public interface UserService extends IService<User> {

    User getByUserId(long id);
}
