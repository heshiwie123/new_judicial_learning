package com.he;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.he.domin.entity.mysql.ExercisesRecord;
import com.he.service.IExercisesRecordService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExercisesRecordTest {
    @Resource
    private IExercisesRecordService exercisesRecordService;
//    @Test
//    public void test1(){
//        ExercisesRecord exercisesRecord = new ExercisesRecord();
//
//        exercisesRecord.setUserId(10);
//        exercisesRecord.setExercisesId("663b6cdad2f2ec19ae383de8");
//        exercisesRecord.setAnswer("A");
//        //题目分数不固定，或则根据前端设定，或则根据题型和卷面总分设计
//        exercisesRecord.setResultMark(0);
//        exercisesRecord.setIsCorrect(false);
//
//        Integer result = exercisesRecordService.addUserExercisesRecord(exercisesRecord);
//        System.out.println(result);
//
//    }
//
//    @Test
//    public void test2(){
//        Page<ExercisesRecord> exercisesRecordList = exercisesRecordService.getExercisesRecordListByUserId(10, 0, 4);
//        System.out.println(exercisesRecordList);
//    }
}
