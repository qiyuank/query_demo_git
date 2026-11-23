package com.kk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kk.entity.User;
import com.kk.response.Result;
import com.kk.service.UserService;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/{id}")
	public Result<User> getById(@PathVariable Long id){
		User user = userService.getUserById(id);
		 if (user == null) {
	            return Result.error(404, "用户不存在");
	        }
	     return Result.success(user);
	}

	
	

}
