package com.he.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.domin.dto.UpdateDanmuDto;
import com.he.domin.entity.mysql.Danmu;

import java.util.ArrayList;

public interface IDanmuService extends IService<Danmu> {
    /**
     * 根据视频id获取其对应得弹幕列表
     * @param videoId 视频id
     * @return 弹幕列表
     */
    public ArrayList<Danmu> getDanmuListByVideoId(int videoId);

    /**
     * 添加弹幕
     * @param danmu 弹幕集体内容
     * @return 返回结果
     */
    public int addDanmuByUserIdAndVideoId(Danmu danmu);

    /**
     * 更新弹幕信息
     * @param danmuDto 更新弹幕信息的dto
     * @return 返回结果
     */
    public int updateDanmuInfo(UpdateDanmuDto danmuDto);
}
