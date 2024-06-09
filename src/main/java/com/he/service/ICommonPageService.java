package com.he.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.HashMap;
import java.util.List;

public interface ICommonPageService<T> {
    //通用的count方法
    public Long getCountByFilter(LambdaQueryWrapper<T> queryWrapper);
}
