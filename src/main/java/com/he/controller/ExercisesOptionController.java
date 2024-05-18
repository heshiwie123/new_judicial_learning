package com.he.controller;

import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mongo.ExercisesOption;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IExercisesOptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/exercisesOption")
@Tag(name = "题目具体选项内容管理接口")
public class ExercisesOptionController {

    @Resource
    private IExercisesOptionService exercisesOptionService;

    @GetMapping("/getExercisesOptionByExercisesId")
    @Operation(summary = "getExercisesOptionByExercisesId" ,description = "根据题干的id获取题目的每个选项")
    public ResponseResult getExercisesOptionByExercisesId(@RequestParam("exercises_id") String exercises_id){
        log.info("ExercisesOptionController====>getExercisesOptionByExercisesId"+"exercises_id:"+exercises_id);

        List<ExercisesOption> exercisesOptionList = exercisesOptionService.getExercisesOptionByExercisesId(exercises_id);
        //查询数据
        HashMap<String,List<ExercisesOption>> exercisesOptionListMap = new HashMap<String,List<ExercisesOption>>();

        exercisesOptionListMap.put("exercisesOptionList",exercisesOptionList);
        //结果包装
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),"获取成功",exercisesOptionListMap);
    }
}
