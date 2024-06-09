package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.BrowseHistoryUpdateRequestDto;
import com.he.domin.entity.mysql.BrowseHistory;
import com.he.mapper.BrowseHistoryMapper;
import com.he.service.IBrowseHistoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class BrowseHistoryServiceImpl extends ServiceImpl<BrowseHistoryMapper, BrowseHistory> implements IBrowseHistoryService {


    @Resource
    private BrowseHistoryMapper browseHistoryMapper;

    @Override
    public BrowseHistory getBrowseHistoryByUserIdAndVideoId(int userId, int videoId) {

        //日志
        log.info("BrowseHistoryServiceImpl====>getBrowseHistoryByUserIdAndVideoId--------->"
                + "用户id userId:" + userId
                + "视频id videoId:" + videoId);
        //查询
        //LambdaQueryWrapper最好不要用bean的方式注入
        //因为Wrapper是记录状态的，全局单例
        //有可能造成缓存影响问题
        BrowseHistory browseHistory = browseHistoryMapper.selectOne(new LambdaQueryWrapper<BrowseHistory>()
                .eq(BrowseHistory::getUserId, userId)
                .eq(BrowseHistory::getVideoId, videoId));

        log.info("browseHistory====>" + browseHistory);
        return browseHistory;
    }

    @Override
    public Integer updateBrowseHistoryByBrowseHistoryId(BrowseHistoryUpdateRequestDto browseHistoryDto) {
        //日志
        log.info("BrowseHistoryServiceImpl====>updateBrowseHistoryByBrowseHistoryId--------->"
                + "浏览记录id browseHistoryId:" + browseHistoryDto.getBrowseHistoryId()
                + "更新时间 updateTime:" + browseHistoryDto.getUpdateTime()
                + "新的观看进度 timeStamp:" + browseHistoryDto.getTimeStamp()
                + "点赞 isLike:" + browseHistoryDto.getIsLike()
                + "转发 isShare:" + browseHistoryDto.getIsShare()
                + "收藏 isCollect:" + browseHistoryDto.getIsCollect());

        //浏览记录更新
        BrowseHistory browseHistory = new BrowseHistory();
        browseHistory.setId(browseHistoryDto.getBrowseHistoryId());
        browseHistory.setIsCollect(browseHistoryDto.getIsCollect());
        browseHistory.setTimeStamp(browseHistoryDto.getTimeStamp());
        browseHistory.setCreateTime(browseHistoryDto.getUpdateTime()==null?LocalDateTime.now():browseHistoryDto.getUpdateTime());
        browseHistory.setIsLike(browseHistoryDto.getIsLike());
        browseHistory.setIsShare(browseHistoryDto.getIsShare());

        //信息更新

        return browseHistoryMapper.updateById(browseHistory);

    }

    @Override
    public Integer addBrowseHistory(BrowseHistory browseHistory) {
        //日志
        log.info("BrowseHistoryServiceImpl====>addBrowseHistory"+browseHistory);
        //新增记录
        LambdaQueryWrapper<BrowseHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BrowseHistory::getUserId,browseHistory.getUserId());
        queryWrapper.eq(BrowseHistory::getVideoId,browseHistory.getVideoId());
        boolean exists = browseHistoryMapper.exists(queryWrapper);
        if (exists){return  0;}
        return browseHistoryMapper.insert(browseHistory);
    }
}
