package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.PageResponse;
import com.he.domin.dto.VideoRequestDto;
import com.he.domin.dto.VideoUpdateRequestDto;
import com.he.domin.entity.mysql.Video;
import com.mongodb.lang.NonNull;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IVideoService extends IService<Video> {
    /**
     * 根据筛选信息获取视频列表
     *
     * @ compositeFilter 综合筛选
     * @ paymentType     支付类型
     * @ keyWordType     关键词类型
     * @ pageNumber      分页-第几页
     * @ pageSize        分页-每页尺寸
     * @return 视频列表
     */
    public PageResponse<Video> getVideoListByScreen(VideoRequestDto videoRequestDto);

    /**
     * 根据视频id更新视频信息，观看量，点击量等
     * @ videoId 视频id
     * @ sumLike 喜欢
     * @ sumCollect 收藏
     * @ sumComment 评论
     * @ sumShare 转发
     * @ sumView 观看
     * @ sumDanMu 弹幕
     * @return 更新结果
     */
    public int updateVideoByVideoId(VideoUpdateRequestDto videoUpdateRequestDto);
}
