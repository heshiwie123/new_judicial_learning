package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.dto.UpdateDanmuDto;
import com.he.domin.entity.mysql.Danmu;
import com.he.mapper.DanmuMapper;
import com.he.service.IDanmuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DanmuServiceImpl extends ServiceImpl<DanmuMapper, Danmu> implements IDanmuService {

    @Resource
    private LambdaQueryWrapper<Danmu> queryWrapper;
    @Resource
    private LambdaUpdateWrapper<Danmu> updateWrapper;
    @Resource
    private DanmuMapper danmuMapper;
    @Override
    public ArrayList<Danmu> getDanmuListByVideoId(int videoId) {
        //日志记录
        log.info("DanmuServiceImpl======》getDanmuListByVideoId"+"videoId:"+videoId);

        //查询
        queryWrapper.eq(Danmu::getVideoId,videoId);

        queryWrapper.eq(Danmu::getIsDeleted,0);
        ArrayList<Danmu> danmuList = (ArrayList<Danmu>) danmuMapper.selectList(queryWrapper);
        //wrapper清除
        queryWrapper.clear();
        return danmuList;
    }

    @Override
    public int addDanmuByUserIdAndVideoId(Danmu danmu) {
        //日志记录
        log.info("DanmuServiceImpl======》addDanmuByUserIdAndVideoId"+"danmu信息:"+danmu);
        return danmuMapper.insert(danmu);
    }

    @Override
    public int updateDanmuInfo(UpdateDanmuDto danmuDto) {
        //日志记录
        log.info("DanmuServiceImpl======》addDanmuByUserIdAndVideoId"+"danmuDto信息:"+danmuDto);
        //wrapper条件
        updateWrapper.eq(Danmu::getId,danmuDto.getDanmuId());
        if(danmuDto.getColor()!=null){
            updateWrapper.set(Danmu::getColor,danmuDto.getColor());
        }
        if(danmuDto.getIsDeleted()!=null){
            updateWrapper.set(Danmu::getIsDeleted,danmuDto.getIsDeleted());
        }
        if(danmuDto.getSumLike()!=null){
            updateWrapper.set(Danmu::getSumLike,danmuDto.getSumLike());
        }
        if(danmuDto.getIsHot()!=null){
            updateWrapper.set(Danmu::getIsHot,danmuDto.getIsHot());
        }
        //更新
        int result = danmuMapper.update(null, updateWrapper);
        //清除
        updateWrapper.clear();
        return result;
    }
}
