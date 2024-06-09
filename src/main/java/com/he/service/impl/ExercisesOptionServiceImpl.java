package com.he.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.he.domin.entity.mongo.ExercisesOption;
import com.he.mapper.IExercisesOptionMapper;
import com.he.service.IExercisesOptionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public class ExercisesOptionServiceImpl implements IExercisesOptionService {
    @Resource
    private IExercisesOptionMapper exercisesOptionMapper;


    @Override
    public List<ExercisesOption> getExercisesOptionByExercisesId(String exercisesId) {
        return exercisesOptionMapper.getExercisesOptionByExercisesId(exercisesId);
    }

    @Override
    public HashMap<String, List<ExercisesOption>> getExercisesOptionByExercisesIdList(List<String> exercisesIdList) {

        return exercisesOptionMapper.getExercisesOptionByExercisesIdList(exercisesIdList);
    }
}
