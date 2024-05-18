package com.he.service;

import com.he.domin.entity.mongo.Exercises;
import com.mongodb.lang.Nullable;

import java.util.List;

public interface IExercisesService {
    /**
     * 根据题目类型和提数获取题目
     * @param exercise_type 题目类型
     * @param sum 数量
     * @return 题目列表
     */
    public List<Exercises> getExercisesList(Integer exercise_type , @Nullable Integer sum);
}
