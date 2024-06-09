package com.he;

import com.he.domin.entity.mongo.Exercises;
import com.he.domin.enums.ExercisesType;
import com.he.domin.enums.OptionType;
import com.he.mapper.IExercisesMapper;
import com.he.service.IExercisesService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class ExercisesTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private IExercisesMapper exercisesMapper;

    @Resource
    private IExercisesService exercisesService;

    @Test
    public void testAddExercises(){
        Exercises exercises = new Exercises();
        exercises.setType(ExercisesType.CHOICE.getCode()).setTitle("下列情形中属于效力特定合同的有？")
                .setExplain("解释").setCorrect_answer(OptionType.OPTION_B.getCode());

        Exercises exercises1 = mongoTemplate.insert(exercises,"exercises");
        System.out.println(exercises1);
    }
    @Test
    public void test1(){
        List<Exercises> exercisesList = exercisesMapper.getExercisesList(1, 5);
        exercisesList.forEach(System.out::println);
    }

    @Test
    public void testService(){
        List<Exercises> exercisesList = exercisesService.getExercisesList(1, 5);
        exercisesList.forEach(System.out::println);
    }

}
