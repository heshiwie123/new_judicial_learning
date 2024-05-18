package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;
@Data
@TableName("video")
@Accessors(chain = true)
public class Video {
    /**
     * 视频id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 视频标题
     */
    @TableField("title")
    private String title;
    /**
     * 视频所属机构
     */
    @TableField("video_up")
    private String videoUp;
    /**
     * 视频简介
     */
    @TableField("brief_intro")
    private String briefIntro;
    /**
     * 视频url
     */
    @TableField("video_url")
    private String videoUrl;
    /**
     * 视频封面url
     */
    @TableField("cover_img_url")
    private String coverImgUrl;
    /**
     * 总点赞量
     */
    @TableField("sum_like")
    private int sumLike;
    /**
     * 总收藏量
     */
    @TableField("sum_collect")
    private int sumCollect;
    /**
     * 总评论量
     */
    @TableField("sum_comment")
    private int sumComment;
    /**
     * 总转发量
     */
    @TableField("sum_share")
    private int sumShare;
    /**
     * 总播放量
     */
    @TableField("sum_view")
    private int sumView;
    /**
     * 总弹幕量
     */
    @TableField("sum_danmu")
    private int sumDanMu;

    /**
     * 总视频长度：分钟
     */
    @TableField("duration")
    private int duration;
    /**
     * 视频发布时间
     */
    @TableField("publish_time")
    private LocalDate publishTime;
    /**
     * 视频是否免费
     */
    @TableField("payment_type")
    private Boolean paymentType;

}
