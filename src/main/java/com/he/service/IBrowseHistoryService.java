package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.BrowseHistoryUpdateRequestDto;
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
     * @ browseHistoryId 浏览记录id
     * @ timeStamp 观看时间戳
     * @ updateTime 更新时间
     * @ isLike 点赞
     * @ isShare 转发
     * @ isCollect 收藏
     */
    public Integer updateBrowseHistoryByBrowseHistoryId(BrowseHistoryUpdateRequestDto browseHistoryDto);

    /**
     * 插入浏览记录
     * @param browseHistory 浏览记录实体
     * @return 执行结果
     */
    public Integer addBrowseHistory(BrowseHistory browseHistory);
}
