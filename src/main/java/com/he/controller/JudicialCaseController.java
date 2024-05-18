package com.he.controller;

import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mongo.JudicialCase;
import com.he.service.IJudicialCaseService;
import com.mongodb.lang.Nullable;
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
@RequestMapping("/judicialCase")
@Tag(name = "司法案例获取接口")
public class JudicialCaseController {

    @Resource
    IJudicialCaseService judicialCaseService;

    @GetMapping("/getJudicialCaseList")
    @Operation(summary = "getJudicialCaseList" ,description = "根据合同类型、发布部门、进行获取司法案例，这里根据效力级别排序同时根据分页查询条件获取")
    public ResponseResult getJudicialCaseList(@RequestParam("contract_type") @Nullable Integer contract_type,
                                              @RequestParam("legal_nature") @Nullable Integer legal_nature,
                                              @RequestParam("formulation_organ") @Nullable Integer formulation_organ,
                                              @RequestParam("pageIndex") Integer pageIndex,
                                              @RequestParam("perPageSum") Integer perPageSum){
        //日志记录
        log.info("JudicialCaseController=====>getJudicialCaseList"+"contract_type:"+contract_type+"legal_nature:"+legal_nature+"pageIndex:"+pageIndex+"perPageSum:"+perPageSum);

        //查询数据
        List<JudicialCase> judicialCaseList = judicialCaseService.getJudicialCaseList(contract_type, legal_nature, formulation_organ, pageIndex, perPageSum);

        //包装数据
        HashMap<String, List<JudicialCase>> judicialCaseListMap = new HashMap<>();

        judicialCaseListMap.put("judicialCaseList",judicialCaseList);

        return ResponseResult.okResult(judicialCaseListMap);
    }

    @GetMapping("/getJudicialCaseListByTile")
    @Operation(summary = "getJudicialCaseListByTile" ,description = "根据标题内容进行模糊查询获取司法案例，这里根据效力级别排序同时根据分页查询条件获取")
    public ResponseResult getJudicialCaseListByTile(@RequestParam("title") @Nullable String title,
                                                        @RequestParam("pageIndex") Integer pageIndex,
                                                        @RequestParam("perPageSum") Integer perPageSum){

        //日志记录
        log.info("JudicialCaseController=====>getJudicialCaseList"+"title:"+title+"pageIndex:"+pageIndex+"perPageSum:"+perPageSum);

        //查询数据
        List<JudicialCase> judicialCaseList = judicialCaseService.getJudicialCaseListByTile(title , pageIndex, perPageSum);

        //包装数据
        HashMap<String, List<JudicialCase>> judicialCaseListMap = new HashMap<>();

        judicialCaseListMap.put("judicialCaseList",judicialCaseList);

        return ResponseResult.okResult(judicialCaseListMap);
    }
}
