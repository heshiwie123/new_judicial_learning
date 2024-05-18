package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.entity.mysql.BrowseHistory;
import com.he.mapper.BrowseHistoryMapper;
import com.he.service.IBrowseHistoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class BrowseHistoryServiceImpl extends ServiceImpl<BrowseHistoryMapper, BrowseHistory>  implements IBrowseHistoryService {
    @Resource
    private LambdaQueryWrapper<BrowseHistory> queryWrapper;
    @Resource
    private LambdaUpdateWrapper<BrowseHistory> updateWrapper;

    @Resource
    private BrowseHistoryMapper browseHistoryMapper;

    @Override
    public BrowseHistory getBrowseHistoryByUserIdAndVideoId(int userId, int videoId) {

        //日志
        log.info("BrowseHistoryServiceImpl====>getBrowseHistoryByUserIdAndVideoId--------->"
                +"用户id userId:"+userId
                +"视频id videoId:"+videoId);
        queryWrapper.eq(BrowseHistory::getUserId,userId);
        queryWrapper.eq(BrowseHistory::getVideoId,videoId);

        //查询
        BrowseHistory browseHistory = browseHistoryMapper.selectOne(queryWrapper);

        //queryWrapper清除
        queryWrapper.clear();

        return browseHistory;
    }

    @Override
    public Integer updateBrowseHistoryByBrowseHistoryId(int browseHistoryId, int timeStamp, LocalDateTime updateTime
                                                    , boolean isLike, boolean isShare
                                                    , boolean isCollect) {
        //日志
        log.info("BrowseHistoryServiceImpl====>updateBrowseHistoryByBrowseHistoryId--------->"
                +"浏览记录id browseHistoryId:"+browseHistoryId
                +"更新时间 updateTime:"+updateTime
                +"新的观看进度 timeStamp:"+timeStamp
                +"点赞 isLike:"+isLike
                +"转发 isShare:"+isShare
                +"收藏 isCollect:"+isCollect);

        //浏览记录更新
        updateWrapper.eq(BrowseHistory::getId,browseHistoryId);
        updateWrapper.set(BrowseHistory::getTimeStamp,timeStamp);
        updateWrapper.set(BrowseHistory::getCreateTime,updateTime);
        updateWrapper.set(BrowseHistory::getIsLike,isLike);
        updateWrapper.set(BrowseHistory::getIsShare,isShare);
        updateWrapper.set(BrowseHistory::getIsCollect,isCollect);

        //信息更新
        int result = browseHistoryMapper.update(null, updateWrapper);

        //清除
        updateWrapper.clear();
        return result;
    }
}
