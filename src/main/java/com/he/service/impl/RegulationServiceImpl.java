package com.he.service.impl;

import com.he.domin.entity.mongo.Regulation;
import com.he.mapper.IRegulationMapper;
import com.he.service.IRegulationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegulationServiceImpl implements IRegulationService {
    @Resource
    private IRegulationMapper regulationMapper;


    @Override
    public List<Regulation> getRegulationList(Integer formulation_organ, Integer pageIndex, Integer perPageSum) {
        return regulationMapper.getRegulationList(formulation_organ,pageIndex, perPageSum);
    }

    @Override
    public List<Regulation> getRegulationListByTitle(String title, Integer formulation_organ, Integer pageIndex, Integer perPageSum) {
        return regulationMapper.getRegulationListByTitle(title,formulation_organ,pageIndex,perPageSum);
    }
}
