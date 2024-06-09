package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.service.ICommonPageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


//服务是无状态的
//使用 Spring 的依赖注入时的关键考虑
@Service
public class CommonPageService<T> implements ICommonPageService<T> {

    private BaseMapper<T> mapper;
    @Override
    public Long getCountByFilter(LambdaQueryWrapper<T> queryWrapper) {
        return mapper.selectCount(queryWrapper);
    }
    public void setBaseMapper(BaseMapper<T> mapper) {
        this.mapper = mapper;
    }
}
