package com.he.controller;

import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mongo.Exercises;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IExercisesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/Exercises")
@Tag(name = "习题题干管理接口")
public class ExercisesController {

    @Resource
    private IExercisesService exercisesService;


    @GetMapping("/getExercisesList")
    @Operation(summary = "getExercisesList" ,description = "根据题目类型和数量获取题干")
    public ResponseResult getExercisesList(
            @RequestParam("exercise_type") Integer exerciseType,
            @RequestParam(value = "sum", required = false) Integer sum){

        //查询
        List<Exercises> exercisesList = exercisesService.getExercisesList(exerciseType, sum);

        //返回结果包装

        HashMap<String, List<Exercises>> exercisesListMap =new HashMap<>();
        exercisesListMap.put("exercisesList",exercisesList);
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),"获取成功",exercisesListMap);
    }
}
