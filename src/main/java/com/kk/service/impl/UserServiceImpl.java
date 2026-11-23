package com.kk.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.entity.User;
import com.kk.mapper.UserMapper;
import com.kk.response.Result;
import com.kk.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	
	@Autowired
	UserMapper userMapper;
	

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectById(id);
		return user;
	
	}

	

}
