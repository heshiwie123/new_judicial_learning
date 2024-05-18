package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.domin.entity.mysql.ExercisesRecord;
import com.he.mapper.ExercisesRecordMapper;
import com.he.service.IExercisesRecordService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ExercisesRecordServiceImpl extends ServiceImpl<ExercisesRecordMapper, ExercisesRecord> implements IExercisesRecordService {
    @Resource
    private ExercisesRecordMapper exercisesRecordMapper;
    @Resource
    private LambdaUpdateWrapper<ExercisesRecord> updateWrapper;
    @Resource
    private LambdaQueryWrapper<ExercisesRecord>  queryWrapper;

    @Override
    public Integer addUserExercisesRecord(ExercisesRecord exercisesRecord) {
        log.info("ExercisesRecordServiceImpl=====>addUserExercisesRecord"+"用户作答记录 exercisesRecord:"+exercisesRecord);

        return exercisesRecordMapper.insert(exercisesRecord);
    }

    @Override
    public List<ExercisesRecord> getExercisesRecordListByUserId(Integer userId) {
        log.info("ExercisesRecordServiceImpl=====>getExercisesRecordListByUserId"+"查找用户id userId:"+userId);

        queryWrapper.eq(ExercisesRecord::getUserId,userId);
        //查询
        List<ExercisesRecord> exercisesRecords = exercisesRecordMapper.selectList(queryWrapper);
        //清除
        queryWrapper.clear();

        return exercisesRecords;
    }
}
