package com.he.domin.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Exercises {
    @Id
    private String id;
    @Field
    private String title;   //题干内容
    @Field
    private Integer type;   //题目类型
    @Field
    private Integer correct_answer; //正确答案
    @Field
    private String explain; //题目解释
    @Field
    private String regulation_id;   //考察到的法规id


    public Exercises(String title, Integer type, Integer correct_answer, String explain, String regulation_id) {
        this.title = title;
        this.type = type;
        this.correct_answer = correct_answer;
        this.explain = explain;
        this.regulation_id = regulation_id;
    }
}
