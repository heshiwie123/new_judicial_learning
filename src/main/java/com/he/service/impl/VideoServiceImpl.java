package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.entity.mysql.BrowseHistory;
import com.he.domin.entity.mysql.Video;
import com.he.domin.enums.VideoFilterType;
import com.he.mapper.VideoMapper;
import com.he.service.IVideoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>implements IVideoService{

    @Resource
    private LambdaUpdateWrapper<Video> updateWrapper;
    @Resource
    private VideoMapper videoMapper;

    /**
     * 根据筛选条件获取视频列表
     * @param compositeFilter 综合筛选
     * @param paymentType 是否付费
     * @param keyWordType 关键词
     */
    @Override
    public ArrayList<Video> getVideoListByScreen(int compositeFilter, Boolean paymentType, Integer keyWordType, int pageNumber, int pageSize) {
        //日志
        log.info("VideoServiceImpl===>getVideoListByScreen----->"
                +"综合筛选compositeFilter:"+compositeFilter
                +"是否付费paymentType:"+paymentType
                +"关键词类型keyWordType:"+keyWordType);

        String keyWord = VideoFilterType.getNameByCode(keyWordType);
        System.out.println("keyWord=====>"+keyWord);

        int pageSkip = pageNumber*pageSize;
        //进行查询
        return videoMapper.getVideoListByScreen(compositeFilter, paymentType, keyWord,pageSkip,pageSize);
    }

    @Override
    public int updateVideoByVideoId(int videoId, int sumLike
                                                , int sumCollect, int sumComment
                                                , int sumShare, int sumView
                                                , int sumDanMu) {
        //日志
        log.info("VideoServiceImpl===>updateVideoByVideoIdAndUserId----->"
                +"视频id videoId:"+videoId
                +"总点赞量 sumLike:"+sumLike
                +"总收藏量 sumCollect:"+sumCollect
                +"总评论量 sumComment:"+sumComment
                +"总转发量 sumShare:"+sumShare
                +"总观看量 sumView:"+sumView
                +"总弹幕量 sumDanMu:"+sumDanMu);
        //条件
        updateWrapper.eq(Video::getId,videoId);
        //更新
        updateWrapper.set(Video::getSumLike,sumLike);
        updateWrapper.set(Video::getSumCollect,sumCollect);
        updateWrapper.set(Video::getSumComment,sumComment);
        updateWrapper.set(Video::getSumShare,sumShare);
        updateWrapper.set(Video::getSumView,sumView);
        updateWrapper.set(Video::getSumDanMu,sumDanMu);
        //清除
        int result = videoMapper.update(null, updateWrapper);

        updateWrapper.clear();
        return result;
    }
}
