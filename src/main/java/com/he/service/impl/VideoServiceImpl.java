package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.PageResponse;
import com.he.domin.dto.ResponseResult;
import com.he.domin.dto.VideoRequestDto;
import com.he.domin.dto.VideoUpdateRequestDto;
import com.he.domin.entity.mysql.BrowseHistory;
import com.he.domin.entity.mysql.Video;
import com.he.domin.enums.VideoFilterType;
import com.he.mapper.VideoMapper;
import com.he.service.ICommonPageService;
import com.he.service.IVideoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Resource
    private VideoMapper videoMapper;

//    @Resource
//    private CommonPageService<Video> commonPageService;

    /**
     * 根据筛选条件获取视频列表
     * compositeFilter 综合筛选
     * paymentType 是否付费
     * keyWordType 关键词
     */
    @Override
    public PageResponse<Video> getVideoListByScreen(VideoRequestDto videoRequestDto) {
        //日志
        log.info("VideoServiceImpl===>getVideoListByScreen----->"
                + "综合筛选compositeFilter:" + videoRequestDto.getCompositeFilter()
                + "是否付费paymentType:" + videoRequestDto.getPaymentType()
                + "关键词类型keyWordType:" + videoRequestDto.getKeyWordType());

        String keyWord = VideoFilterType.getNameByCode(videoRequestDto.getKeyWordType());
        if (videoRequestDto.getPageSize() == null) videoRequestDto.setPageSize(1);
        if (videoRequestDto.getPageNumber() == null) videoRequestDto.setPageNumber(Integer.MAX_VALUE);
        System.out.println("keyWord=====>" + keyWord);
        //获得跳过的页码
        int pageSkip = (videoRequestDto.getPageNumber() - 1) * videoRequestDto.getPageSize();
        //获取实际视频数据
        ArrayList<Video> videoList = videoMapper.getVideoListByScreen(
                videoRequestDto.getCompositeFilter()
                , videoRequestDto.getPaymentType()
                , keyWord
                , pageSkip
                , videoRequestDto.getPageSize());
        //获取总数筛查
        Long total = videoMapper.selectCount(new LambdaQueryWrapper<Video>()
                .eq(Video::getPaymentType, videoRequestDto.getPaymentType())
                .like(Video::getTitle, keyWord));
        // 构造分页结果
        PageResponse<Video> pageResult = new PageResponse<>();
        pageResult.setRecords(videoList)
                .setPages((int) Math.ceil((double) total / videoRequestDto.getPageSize()))
                .setTotal(total)
                .setSize(videoRequestDto.getPageSize())
                .setCurrent(videoRequestDto.getPageNumber());

        return pageResult;

    }

    @Override
    public int updateVideoByVideoId(VideoUpdateRequestDto videoUpdateRequestDto) {
        //日志
        log.info("VideoServiceImpl===>updateVideoByVideoIdAndUserId----->"
                + "视频id videoId:" + videoUpdateRequestDto.getVideoId()
                + "总点赞量 sumLike:" + videoUpdateRequestDto.getSumCollect()
                + "总收藏量 sumCollect:" + videoUpdateRequestDto.getSumCollect()
                + "总评论量 sumComment:" + videoUpdateRequestDto.getSumComment()
                + "总转发量 sumShare:" + videoUpdateRequestDto.getSumShare()
                + "总观看量 sumView:" + videoUpdateRequestDto.getSumView()
                + "总弹幕量 sumDanMu:" + videoUpdateRequestDto.getSumDanMu());
        //条件
        LambdaUpdateWrapper<Video> updateWrapper = new LambdaUpdateWrapper<Video>();
        updateWrapper.eq(Video::getId, videoUpdateRequestDto.getVideoId());
        //更新
        updateWrapper.set(videoUpdateRequestDto.getSumLike() != null, Video::getSumLike, videoUpdateRequestDto.getSumLike());
        updateWrapper.set(videoUpdateRequestDto.getSumCollect() != null, Video::getSumCollect, videoUpdateRequestDto.getSumCollect());
        updateWrapper.set(videoUpdateRequestDto.getSumComment() != null, Video::getSumComment, videoUpdateRequestDto.getSumComment());
        updateWrapper.set(videoUpdateRequestDto.getSumShare() != null, Video::getSumShare, videoUpdateRequestDto.getSumShare());
        updateWrapper.set(videoUpdateRequestDto.getSumView() != null, Video::getSumView, videoUpdateRequestDto.getSumView());
        updateWrapper.set(videoUpdateRequestDto.getSumDanMu() != null, Video::getSumDanMu, videoUpdateRequestDto.getSumDanMu());

        return videoMapper.update(null,updateWrapper);
    }
}
