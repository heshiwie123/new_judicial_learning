package com.he.domin.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExercisesOption {
    @Id
    private String id;
    @Field
    private Integer option_type;    //选项
    @Field
    private String content;    //具体内容
    @Field
    private String exercises_id;    //对映得题目id

    public ExercisesOption(Integer option_type, String content, String exercises_id) {
        this.option_type = option_type;
        this.content = content;
        this.exercises_id = exercises_id;
    }
}
