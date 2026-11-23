package com.kk.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("demo_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    public Long id;
    public String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
