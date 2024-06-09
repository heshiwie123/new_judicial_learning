package com.he.mapper;

import com.he.domin.entity.mongo.ExercisesOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
public interface IExercisesOptionMapper {
    //根据题目的id获取选项内容
    public List<ExercisesOption> getExercisesOptionByExercisesId(String exercises_id);

    //根据题目的id列表批量获取
    public HashMap<String,List<ExercisesOption>> getExercisesOptionByExercisesIdList(List<String> exercisesIdList);

}
