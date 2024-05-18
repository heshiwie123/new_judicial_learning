package com.he.mapper;

import com.he.domin.entity.mongo.Regulation;
import com.mongodb.lang.Nullable;

import java.util.List;

public interface IRegulationMapper {
    //按效力级别排序
    public List<Regulation> getRegulationList(@Nullable Integer formulation_organ,Integer pageIndex, Integer perPageSum);

    public List<Regulation> getRegulationListByTitle(String title,@Nullable Integer formulation_organ,Integer pageIndex, Integer perPageSum);

}
