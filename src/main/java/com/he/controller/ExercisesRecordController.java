package com.he.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mysql.ExercisesRecord;
import com.he.domin.enums.AppHttpCodeEnum;
import com.he.service.IExercisesRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "答题记录接口")
@RequestMapping("/exercisesRecord")
public class ExercisesRecordController {
    @Resource
    private IExercisesRecordService exercisesRecordService;

    @GetMapping("/getExercisesRecordListByUserId")
    @Operation(summary = "getExercisesRecordListByUserId" ,description = "根据用户id,根据分页查询获取答题记录页")
    public ResponseResult getExercisesRecordListByUserId(@Param("userId") Integer userId
                                                        , @Nullable @Param("pageIndex") Integer pageIndex
                                                        , @Nullable @Param("pageSize") Integer pageSize){
        Page<ExercisesRecord> exercisesRecordList = exercisesRecordService.getExercisesRecordListByUserId(userId, pageIndex, pageSize);

        HashMap<String,Page<ExercisesRecord>> resultMap = new HashMap<>();

        resultMap.put("exercisesRecordList",exercisesRecordList);

        return new ResponseResult<>(200,"成功",resultMap);
    }

    @PutMapping("/addUserExercisesRecord")
    @Operation(summary = "addUserExercisesRecord" ,description = "添加答题记录")
    public ResponseResult addUserExercisesRecord(@RequestBody ExercisesRecord exercisesRecord){
        Integer result = exercisesRecordService.addUserExercisesRecord(exercisesRecord);
        if (result!=0) return ResponseResult.okResult(200,"添加答题记录成功！");
        return ResponseResult.errorResult(AppHttpCodeEnum.FAILED,"添加答题记录失败！");
    }

}
