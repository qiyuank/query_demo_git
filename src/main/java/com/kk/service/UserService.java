package com.kk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kk.entity.User;
import com.kk.response.Result;

public interface UserService extends IService<User> {
    // 自定义业务方法可以写在这里，基础的 getById 已由 IService 提供
	User getUserById(Long id);
}