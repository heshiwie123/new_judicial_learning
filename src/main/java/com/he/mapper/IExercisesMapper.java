package com.he.mapper;

import com.he.domin.entity.mongo.Exercises;
import com.mongodb.lang.Nullable;

import java.util.List;

//题目题干
public interface IExercisesMapper{
    //获取题目列表，根据题目类型，题目数量获取一定量的题目
    public List<Exercises> getExercisesList(Integer exercise_type , @Nullable Integer sum);

}
