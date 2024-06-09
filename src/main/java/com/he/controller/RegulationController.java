package com.he.controller;

import com.he.domin.dto.ResponseResult;
import com.he.domin.entity.mongo.Regulation;
import com.he.service.IRegulationService;
import com.mongodb.lang.Nullable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/regulation")
@Tag(name = "法规信息管理接口")
public class RegulationController {

    @Resource
    private IRegulationService regulationService;

    @GetMapping("/getRegulationList")
    @Operation(summary = "getRegulationList", description = "根据效力级别排序，根据分页查询获取法规列表")
    public ResponseResult getRegulationList(@RequestParam("formulation_organ") @Nullable Integer formulation_organ,
                                            @RequestParam("pageIndex") @Nullable Integer pageIndex,
                                            @RequestParam("perPageSum") @Nullable Integer perPageSum) {
        log.info("RegulationController=====>getRegulationList" + "pageIndex:" + pageIndex + "perPageSum:" + perPageSum);

        List<Regulation> regulationList = regulationService.getRegulationList(formulation_organ, pageIndex, perPageSum);

        //数据包装
        HashMap<String, List<Regulation>> regulationListMap = new HashMap<>();

        regulationListMap.put("regulationList", regulationList);
        return new ResponseResult(200, "查询法规成功", regulationListMap);
    }

    @GetMapping("/getRegulationListByTitle")
    @Operation(summary = "getRegulationListByTitle", description = "根据效力级别排序，部分标题内容进行模糊查询，根据分页查询获取法规列表")
    public ResponseResult getRegulationListByTitle(@RequestParam("title") String title,
                                                   @RequestParam("formulation_organ") @Nullable Integer formulation_organ,
                                                   @RequestParam("pageIndex") @Nullable Integer pageIndex,
                                                   @RequestParam("perPageSum") @Nullable Integer perPageSum) {

        log.info("RegulationController=====>getRegulationList" + "title:" + title + "pageIndex:" + pageIndex + "perPageSum:" + perPageSum);

        //查询
        List<Regulation> regulationList = regulationService.getRegulationListByTitle(title, formulation_organ, pageIndex, perPageSum);

        //数据包装
        HashMap<String, List<Regulation>> regulationListMap = new HashMap<>();

        regulationListMap.put("regulationList", regulationList);

        return new ResponseResult(200, "获取法规信息成功", regulationListMap);
    }
}
