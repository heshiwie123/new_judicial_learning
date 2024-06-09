package com.he.controller;

import com.he.domin.dto.ExercisesListResponseDto;
import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mongo.Exercises;
import com.he.domin.entity.mongo.ExercisesOption;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IExercisesOptionService;
import com.he.service.IExercisesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Exercises")
@Tag(name = "习题题干管理接口")
public class ExercisesController {

    @Resource
    private IExercisesService exercisesService;

    @Resource
    private IExercisesOptionService exercisesOptionService;


    @GetMapping("/getExercisesList")
    @Operation(summary = "getExercisesList" ,description = "根据题目类型和数量获取题干")
    public ResponseResult getExercisesList(
            @RequestParam("exercise_type") Integer exerciseType,
            @RequestParam(value = "sum", required = false) Integer sum){

        if (sum == null) sum = 10;
        //查询题干
        List<Exercises> exercisesList = exercisesService.getExercisesList(exerciseType, sum);

        //得到Exercises的id列表
        List<String> exercisesIdList = exercisesList.stream().map(Exercises::getId).collect(Collectors.toList());
        //查询选项
        HashMap<String, List<ExercisesOption>> exercisesOptionAndExercisesOptionListMap = exercisesOptionService.getExercisesOptionByExercisesIdList(exercisesIdList);

        //返回结果包装
        List<ExercisesListResponseDto> exercisesListResponseDtos = new ArrayList<>();

        exercisesList.forEach(exercises -> {
            exercisesOptionAndExercisesOptionListMap.forEach((s,exercisesOptionList)->{
                if (exercises.getId() == s) {
                    ExercisesListResponseDto exercisesListResponseDto = new ExercisesListResponseDto();
                    exercisesListResponseDto.setExercises(exercises);
                    exercisesListResponseDto.setExercisesOptionList(exercisesOptionList);

                    //
                    exercisesListResponseDtos.add(exercisesListResponseDto);
                }
            });
        });

        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),"获取成功",exercisesListResponseDtos);
    }
}
