package com.he.service;

import com.he.domin.entity.mongo.ExercisesOption;

import java.util.HashMap;
import java.util.List;

public interface IExercisesOptionService {
    /**
     * 根据题目的id获取选项内容
     * @param exercisesId 题目id(这里因为是mongodb的默认_id,所以是16位的字符串id)
     * @return 选项列表
     */
    public List<ExercisesOption> getExercisesOptionByExercisesId(String exercisesId);

    /**
     * 根据题目列表获取每个题目的选项
     * @param exercisesIdList 题目的id列表
     * @return 题目与选项的对应
     */
    public HashMap<String,List<ExercisesOption>> getExercisesOptionByExercisesIdList(String[] exercisesIdList);
}
