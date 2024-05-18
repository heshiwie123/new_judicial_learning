package com.he.service;

import com.he.domin.entity.mysql.ExercisesRecord;

import java.util.List;

public interface IExercisesRecordService{
    /**
     * 记录用户的作答记录
     * @param exercisesRecord 作答记录
     * @return 执行结果
     */
    public Integer addUserExercisesRecord(ExercisesRecord exercisesRecord);

    /**
     * 根据用户id获取答题记录
     * @param userId 用户id
     * @return 答题记录信息
     */
    public List<ExercisesRecord> getExercisesRecordListByUserId(Integer userId);
}
