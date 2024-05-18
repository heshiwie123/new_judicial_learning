package com.he.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.he.domin.entity.mysql.Video;
import com.he.domin.enums.LegalNatureType;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    /**
     * 根据筛选条件获取视频列表
     * 点击最多
     * @return 视频列表
     */
    public ArrayList<Video> getVideoListByScreen(@NonNull @Param("compositeFilter") int compositeFilter,
                                                 @Param("paymentType") Boolean paymentType,
                                                 @Param("keyWord") String keyWord,
                                                 @Param("pageSkip")  int pageSkip,
                                                 @Param("pageSize")int pageSize);
}
