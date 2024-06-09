package com.he;

import com.he.domin.entity.mongo.Exercises;
import com.he.domin.entity.mongo.ExercisesOption;
import com.he.domin.enums.ExercisesType;
import com.he.domin.enums.OptionType;
import com.he.mapper.IExercisesOptionMapper;
import com.he.service.IExercisesOptionService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import jakarta.annotation.Resource;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class ExercisesOptionMapperTest {
    @Resource
    IExercisesOptionMapper exercisesOptionMapper;

    @Resource
    IExercisesOptionService exercisesOptionService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void testAddExercisesOption(){
        List<ExercisesOption> exercisesOptionList = new ArrayList<>();
        ExercisesOption exercisesOption1 = new ExercisesOption();
        exercisesOption1.setOption_type(OptionType.OPTION_A.getCode())
                .setExercises_id("663b6cdad2f2ec19ae383de8")
                .setContent("10周岁的少年出售劳力士金表给40岁的李某");
        exercisesOptionList.add(exercisesOption1);

        ExercisesOption exercisesOption2 = new ExercisesOption();
        exercisesOption2.setOption_type(OptionType.OPTION_B.getCode())
                .setExercises_id("663b6cdad2f2ec19ae383de8")
                .setContent("5周岁的儿童因发明创造而接受奖金");
        exercisesOptionList.add(exercisesOption2);

        ExercisesOption exercisesOption3 = new ExercisesOption();
        exercisesOption3.setOption_type(OptionType.OPTION_C.getCode())
                .setExercises_id("663b6cdad2f2ec19ae383de8")
                .setContent("成年人甲误将本为复制品的油画当成真品购买");
        exercisesOptionList.add(exercisesOption3);

        ExercisesOption exercisesOption4 = new ExercisesOption();
        exercisesOption4.setOption_type(OptionType.OPTION_D.getCode())
                .setExercises_id("663b6cdad2f2ec19ae383de8")
                .setContent("出租车司机借机抢救重病人急需租车之机将车价提高10倍");
        exercisesOptionList.add(exercisesOption4);

        //插入指定集合
        Collection<ExercisesOption> exercisesOptions = mongoTemplate.insert(exercisesOptionList, "exercises_option");

        System.out.println(exercisesOptions);
    }
    @Test
    public void test2(){

        List<ExercisesOption> exercisesOptions = exercisesOptionService.getExercisesOptionByExercisesId("663748534fdc5a05382db12e");
        exercisesOptions.forEach(System.out::println);

    }
    @Test
    public void test78(){
        List<String> exercisesOptionByExercisesIdList = new ArrayList<>();
        exercisesOptionByExercisesIdList.add("663748534fdc5a05382db12e");
        exercisesOptionByExercisesIdList.add("663b6c854def786f21a836c9");
        exercisesOptionByExercisesIdList.add("663b6ca49f5c9f1ef615027a");
        exercisesOptionByExercisesIdList.add("663b6cdad2f2ec19ae383de8");
        HashMap<String, List<ExercisesOption>> exercisesOptionByExercisesIdList1 = exercisesOptionService.getExercisesOptionByExercisesIdList(exercisesOptionByExercisesIdList);
        exercisesOptionByExercisesIdList1.forEach((s, exercisesOptions) -> {
            System.out.println(s);
            System.out.println(exercisesOptions);
        });
    }

}
