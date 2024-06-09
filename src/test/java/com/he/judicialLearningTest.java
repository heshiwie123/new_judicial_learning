package com.he;

import com.he.domin.entity.mongo.JudicialCase;
import com.he.domin.enums.ContractType;
import com.he.domin.enums.FormulationOrganType;
import com.he.domin.enums.LegalNatureType;
import com.he.mapper.impl.JudicialCaseMapper;
import com.he.util.DateFormatUtill;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class judicialLearningTest {
    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private JudicialCaseMapper judicialCaseMapper;

    @Test
    public void test1(){
        List<JudicialCase> judicialCaseList = judicialCaseMapper.getJudicialCaseList(ContractType.SALES_CONTRACT.getCode()
                , LegalNatureType.LAW.getCode()
                , FormulationOrganType.SUPREME_COURT.getCode(), 1, 3);
        judicialCaseList.forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<JudicialCase> judicialCaseList = judicialCaseMapper.getJudicialCaseListByTile("委员会",1, 3);
        judicialCaseList.forEach(System.out::println);
    }

    @Test
    public void testJudicialCaseInsert() throws ParseException {
        Date LocalDateTime = new Date();

        /**
         * JudicialCase
         */


        JudicialCase judicialCase = new JudicialCase();
//        judicialCase.setTitle("住房和城乡建设部关于2021年第五批勘察设计工程师初始注册人员的报告");
//        judicialCase.setTitle("中国证券委员会发布审委2021年第142次审核结果公告");
        judicialCase.setTitle("深圳证券交易所关于2015年福建省政府一般债券（三期）上市交易的通知");
        judicialCase.setContract_type(ContractType.SALES_CONTRACT.getCode()); //这里代表买卖合同
        judicialCase.setLegal_nature(LegalNatureType.LAW.getCode());//代表法律
        judicialCase.setFormulation_organ(FormulationOrganType.SUPREME_COURT.getCode());
        judicialCase.setPublish_date(DateFormatUtill.myLocalDateParse("2010-08-30"));
        judicialCase.setForce_date(DateFormatUtill.myLocalDateParse(2010,8,30));
//        judicialCase.setContent("尊敬的各位会员单位：\n" +
//                "\n" +
//                "根据《中国外汇交易中心会员管理办法》的相关规定，我中心经过审查，决定批准南洋商业银行（中国）有限公司成为银行间外汇市场期权会员。该行的会员编号为CNYBANK2022。\n" +
//                "\n" +
//                "特此通知。\n" +
//                "\n" +
//                "中国外汇交易中心\n" +
//                "日期：2024年4月22日");
        judicialCase.setContent_file_url("http://192.168.186.161:9000/file-show/file/show_file1.pdf");
        JudicialCase judicialCase1 = mongoTemplate.insert(judicialCase, "judicial_case");
        System.out.println(judicialCase1);
    }



}