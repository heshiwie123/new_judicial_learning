package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.entity.mysql.BrowseHistory;

import java.time.LocalDateTime;

public interface IBrowseHistoryService extends IService<BrowseHistory> {
    /**
     * 根据用户id和视频id获取对应的浏览记录
     * @param userId 用户id
     * @param videoId 视频id
     * @return 浏览记录
     */
    public BrowseHistory getBrowseHistoryByUserIdAndVideoId( int userId,int videoId);

    /**
     * 根据浏览记录id更新浏览记录
     * @param browseHistoryId 浏览记录id
     * @param timeStamp 观看时间戳
     * @param updateTime 更新时间
     * @param isLike 点赞
     * @param isShare 转发
     * @param isCollect 收藏
     */
    public Integer updateBrowseHistoryByBrowseHistoryId(int browseHistoryId, int timeStamp
                                                    , LocalDateTime updateTime,boolean isLike
                                                    , boolean isShare,boolean isCollect);
}
