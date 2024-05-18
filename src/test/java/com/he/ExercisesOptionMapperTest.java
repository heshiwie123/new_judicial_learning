package com.he;

import com.he.domin.entity.mongo.ExercisesOption;
import com.he.mapper.IExercisesOptionMapper;
import com.he.service.IExercisesOptionService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExercisesOptionMapperTest {
    @Resource
    IExercisesOptionMapper exercisesOptionMapper;

    @Resource
    IExercisesOptionService exercisesOptionService;


    @Test
    public void test1(){

        System.out.println(exercisesOptionMapper.getExercisesOptionByExercisesId("663748534fdc5a05382db12e"));
    }
    @Test
    public void test2(){

        List<ExercisesOption> exercisesOptions = exercisesOptionService.getExercisesOptionByExercisesId("663748534fdc5a05382db12e");
        exercisesOptions.forEach(System.out::println);

    }
}
