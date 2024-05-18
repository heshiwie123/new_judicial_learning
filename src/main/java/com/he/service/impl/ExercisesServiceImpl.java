package com.he.service.impl;

import com.he.domin.entity.mongo.Exercises;
import com.he.mapper.IExercisesMapper;
import com.he.service.IExercisesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExercisesServiceImpl implements IExercisesService {
    @Resource
    private IExercisesMapper exercisesMapper;

    @Override
    public List<Exercises> getExercisesList(Integer exercise_type, Integer sum) {
        return exercisesMapper.getExercisesList(exercise_type,sum);
    }
}
