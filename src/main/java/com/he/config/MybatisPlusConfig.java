package com.he.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @return MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //返回实例
        return interceptor;
    }

    /**
     * LambdaQueryWrapper插件
     * @return 实例
     * @param <T>
     */
    @Bean
    public <T> LambdaQueryWrapper<T> lambdaQueryWrapper(){
        return new LambdaQueryWrapper<T>();
    }

    /**
     * LambdaUpdateWrapper插件
     * @return 实例
     * @param <T>
     */
    @Bean
    public <T> LambdaUpdateWrapper<T> LambdaUpdateWrapper(){
        return new LambdaUpdateWrapper<T>();
    }
}
