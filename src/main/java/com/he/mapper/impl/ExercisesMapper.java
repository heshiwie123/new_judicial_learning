package com.he.mapper.impl;

import com.he.domin.entity.mongo.Exercises;
import com.he.mapper.IExercisesMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
@Slf4j
public class ExercisesMapper implements IExercisesMapper {

    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public List<Exercises> getExercisesList(Integer exercise_type, Integer sum) {
        log.info("ExercisesMapper=======>getExercisesList----->"+"exercise_type"+exercise_type+"sum"+sum);
        Query query = new Query(Criteria.where("type").is(exercise_type));

        //分页
        query.with(Sort.by(Sort.Order.asc("regulation_id")))
                .skip(0)
                .limit(sum);

        //结果
        List<Exercises> exercises = mongoTemplate.find(query, Exercises.class,"exercises");
        log.info("ExercisesMapper=======>getExercisesList----->"+"exercises"+exercises);
        return exercises;
    }

}
