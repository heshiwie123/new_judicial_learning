package com.he.service.impl;

import com.he.domin.entity.mongo.JudicialCase;
import com.he.mapper.IJudicialCaseMapper;
import com.he.service.IJudicialCaseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JudicialCaseServiceImpl implements IJudicialCaseService {
    @Resource
    private IJudicialCaseMapper judicialCaseMapper;


    @Override
    public List<JudicialCase> getJudicialCaseList(Integer contract_type, Integer legal_nature, Integer formulation_organ, Integer pageIndex, Integer perPageSum) {
        return judicialCaseMapper.getJudicialCaseList(contract_type,legal_nature,formulation_organ,pageIndex,perPageSum);
    }

    @Override
    public List<JudicialCase> getJudicialCaseListByTile(String title, Integer pageIndex, Integer perPageSum) {
        return judicialCaseMapper.getJudicialCaseListByTile(title,pageIndex,perPageSum);
    }
}
