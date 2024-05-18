package com.he.mapper.impl;

import com.he.domin.entity.mongo.JudicialCase;
import com.he.mapper.IJudicialCaseMapper;
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
public class JudicialCaseMapper implements IJudicialCaseMapper {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<JudicialCase> getJudicialCaseList(Integer contract_type, Integer legal_nature, Integer formulation_organ, Integer pageIndex, Integer perPageSum) {
        Criteria criteria = new Criteria();
        //条件组合
        criteria.andOperator(Criteria.where("contract_type").is(contract_type)
                , Criteria.where("legal_nature").is(legal_nature),
                Criteria.where("formulation_organ").is(formulation_organ));
        //查询条件
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.asc("formulation_organ")))
                .skip((long) (pageIndex - 1) * perPageSum)
                .limit(perPageSum);

        //查询结果
        List<JudicialCase> judicialCases = mongoTemplate.find(query, JudicialCase.class, "judicial_case");

        log.info("JudicialCaseMapper=======>getJudicialCaseList--->" + "judicialCases:获取成功，获取第" + pageIndex + "页，每页" + perPageSum + "条数据");
        return judicialCases;
    }

    @Override
    public List<JudicialCase> getJudicialCaseListByTile(String title, Integer pageIndex, Integer perPageSum) {
        //查询条件
        Query query = new Query(Criteria.where("title").regex(title));
        query.with(Sort.by(Sort.Order.asc("formulation_organ")))
                .skip((long) (pageIndex - 1) * perPageSum)
                .limit(perPageSum);

        //查询结果
        List<JudicialCase> judicialCases = mongoTemplate.find(query, JudicialCase.class, "judicial_case");

        log.info("JudicialCaseMapper=======>getJudicialCaseListByTile--->" + "judicialCases:获取成功，获取第" + pageIndex + "页，每页" + perPageSum + "条数据");
        return judicialCases;
    }
}
