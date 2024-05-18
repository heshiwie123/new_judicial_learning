package com.he.mapper.impl;

import com.he.domin.entity.mongo.ExercisesOption;
import com.he.mapper.IExercisesOptionMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component //这里不是使用mybatisplus，需要手动注册ExercisesOptionMapper这个bean
public class ExercisesOptionMapper implements IExercisesOptionMapper {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<ExercisesOption> getExercisesOptionByExercisesId(String exercises_id) {
        log.info("ExercisesOptionMapper====>getExercisesOptionByExercisesId-----》"+exercises_id);

        //构造query
        Query query = new Query(Criteria.where("exercises_id").is(exercises_id));

        //查询结果
        List<ExercisesOption> exercisesOptions = mongoTemplate.find(query,ExercisesOption.class,"exercises_option");

        log.info("ExercisesOptionMapper====>getExercisesOptionByExercisesId-----》exercisesOptions----->"+exercisesOptions);
        return exercisesOptions;
    }

    @Override
    public HashMap<String, List<ExercisesOption>> getExercisesOptionByExercisesIdList(String[] exercisesIdList) {
        log.info("ExercisesOptionMapper====>getExercisesOptionByExercisesIdList-----》"+ Arrays.toString(exercisesIdList));

        //构造query
        Query query = new Query(Criteria.where("exercises_id").in((Object) exercisesIdList));

        //查询结果
        List<ExercisesOption> exercisesOptions = mongoTemplate.find(query,ExercisesOption.class,"exercises_option");

        HashMap<String, List<ExercisesOption>> resultMap = new HashMap<>();
        //在内存中数据处理
        for(String exercisesId : exercisesIdList){
            List<ExercisesOption> perOption = new ArrayList<>();
            for (ExercisesOption exercisesOption : exercisesOptions){
                //比对，取出每一个相同的exercisesId放到一个数组内
                if(Objects.equals(exercisesOption.getExercises_id(), exercisesId)) {
                    perOption.add(exercisesOption);
                }
            }
            //每一个exercisesId查找完，插入
            resultMap.put(exercisesId,perOption);
        }
        return resultMap;
    }
}
