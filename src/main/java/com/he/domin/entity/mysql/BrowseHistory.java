package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@TableName("browse_history")
@Accessors(chain = true)
public class BrowseHistory {
    /**
     *历史记录id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 视频id
     */
    @TableField(value = "video_id")
    private Integer videoId;
    /**
     * 观看时间戳
     */
    @TableField(value = "timestamp")
    private Integer timeStamp;
    /**
     * 是否点赞
     */
    @TableField(value = "is_like")
    private Boolean isLike;
    /**
     * 是否转发
     */
    @TableField(value = "is_share")
    private Boolean isShare;
    /**
     * 是否收藏
     */
    @TableField(value = "is_collect")
    private Boolean isCollect;
    /**
     * 是否展示
     */
    @TableField(value = "is_show")
    private Boolean isShow;
    /**
     * 开始观看的时间点
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;
}
