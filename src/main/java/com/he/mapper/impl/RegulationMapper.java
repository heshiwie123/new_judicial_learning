package com.he.mapper.impl;

import com.he.domin.entity.mongo.Regulation;
import com.he.mapper.IRegulationMapper;
import com.mongodb.lang.Nullable;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RegulationMapper implements IRegulationMapper {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Regulation> getRegulationList(@Nullable Integer formulation_organ,Integer pageIndex, Integer perPageSum) {
        log.info("RegulationMapper=======>getRegulationList--->"+"formulation_organ:"+formulation_organ);
        Query query = new Query();
        query.with(Sort.by(Sort.Order.asc("formulation_organ")))
                .skip((long) (pageIndex-1) *perPageSum)
                .limit(perPageSum);
        List<Regulation> regulations = mongoTemplate.find(query, Regulation.class,"regulation");
        log.info("RegulationMapper=======>getRegulationList--->"+"regulations:获取成功，获取第"+pageIndex+"页，每页"+perPageSum+"条数据");
        return regulations;
    }

    @Override
    public List<Regulation> getRegulationListByTitle(String title,@Nullable Integer formulation_organ,Integer pageIndex, Integer perPageSum) {
        log.info("RegulationMapper=======>getRegulationListByTitle--->"+"formulation_organ:"+formulation_organ+"title:"+title);
        Query query = new Query(Criteria.where("title").regex(title));
        query.with(Sort.by(Sort.Order.asc("formulation_organ")))
                .skip((long) (pageIndex-1) *perPageSum)
                .limit(perPageSum);
        List<Regulation> regulations = mongoTemplate.find(query, Regulation.class,"regulation");
        log.info("RegulationMapper=======>getRegulationList--->"+"regulations:获取成功，获取第"+pageIndex+"页，每页"+perPageSum+"条数据");
        return regulations;
    }
}
