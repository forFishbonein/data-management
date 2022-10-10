package com.imis.datamanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.datamanagement.common.R;
import com.imis.datamanagement.domain.User;
import com.imis.datamanagement.mapper.UserMapper;
import com.imis.datamanagement.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
