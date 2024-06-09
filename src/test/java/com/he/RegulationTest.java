package com.he;

import com.he.domin.entity.mongo.Regulation;
import com.he.domin.enums.FormulationOrganType;
import com.he.mapper.IRegulationMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class RegulationTest {
    @Resource
    private IRegulationMapper regulationMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void test1(){
        List<Regulation> regulationList = regulationMapper.getRegulationList(1, 2, 3);
        regulationList.forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Regulation> regulationList = regulationMapper.getRegulationListByTitle("宪法",null ,1, 3);

        regulationList.forEach(System.out::println);
    }
    @Test
    public void test3(){

        System.out.println("123456:");
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    public void testRegulationInsert() {
        /**
         * Regulation
         */
        Regulation regulation = new Regulation();
        regulation.setTitle("宪法");
//        regulation.setPublish_date(new Date(2012, 12, 18));
//        regulation.setForce_data(new Date(2013, 7, 1));
        regulation.setReference_number(null);
        regulation.setFormulation_organ(1);
        regulation.setLegal_nature(0);//代表法律
        regulation.setContent_file_url("http://192.168.186.161:9000/file-show/file/show_file1.pdf");
        Regulation regulation1 = mongoTemplate.insert(regulation, "regulation");
        System.out.println(regulation1);

    }

}
