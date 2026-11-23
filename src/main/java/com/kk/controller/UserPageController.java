package com.kk.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.User;
import org.springframework.web.bind.annotation.RequestParam;
import com.kk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {
    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(@RequestParam(name = "page", defaultValue = "1") long page, Model model) {
        Page<User> result = userService.lambdaQuery().orderByAsc(User::getId)
                .page(new Page<User>(Math.max(1L, page), 15));
        model.addAttribute("users", result.getRecords());
        model.addAttribute("userPage", result);
        return "users";
    }
}
