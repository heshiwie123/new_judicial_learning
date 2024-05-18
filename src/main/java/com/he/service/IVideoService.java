package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.entity.mysql.Video;
import com.mongodb.lang.NonNull;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IVideoService extends IService<Video> {
    /**
     * 根据筛选信息获取视频列表
     *
     * @param compositeFilter 综合筛选
     * @param paymentType     支付类型
     * @param keyWordType     关键词类型
     * @param pageNumber      分页-第几页
     * @param pageSize        分页-每页尺寸
     * @return 视频列表
     */
    public ArrayList<Video> getVideoListByScreen(int compositeFilter, Boolean paymentType, Integer keyWordType, int pageNumber, int pageSize);

    /**
     * 根据视频id更新视频信息，观看量，点击量等
     * @param videoId 视频id
     * @param sumLike 喜欢
     * @param sumCollect 收藏
     * @param sumComment 评论
     * @param sumShare 转发
     * @param sumView 观看
     * @param sumDanMu 弹幕
     * @return 更新结果
     */
    public int updateVideoByVideoId(int videoId, int sumLike
            , int sumCollect, int sumComment
            , int sumShare, int sumView, int sumDanMu);
}
