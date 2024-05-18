package com.he.service;

import com.he.domin.entity.mongo.Regulation;
import com.mongodb.lang.Nullable;

import java.util.List;

public interface IRegulationService {
    public List<Regulation> getRegulationList(@Nullable Integer formulation_organ, Integer pageIndex, Integer perPageSum);

    public List<Regulation> getRegulationListByTitle(String title,@Nullable Integer formulation_organ,Integer pageIndex, Integer perPageSum);
}
