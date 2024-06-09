//package com.he.config;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.he.domin.entity.mysql.Video;
//import com.he.mapper.VideoMapper;
//import com.he.service.ICommonPageService;
//import com.he.service.impl.CommonPageService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CommonPageServiceConfig {
//    @Bean
//    public CommonPageService<Video> videoICommonPageService(VideoMapper videoMapper){
//        CommonPageService<Video> service = new CommonPageService<>() ;
//        service.setBaseMapper(videoMapper);
//        return service;
//    }
//}
