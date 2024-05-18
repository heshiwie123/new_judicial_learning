package com.he.domin.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Regulation {
    @Id
    private String id;
    @Field
    private String title;   //法规标题
    @Field
    private LocalDate publish_date;   //发布日期
    @Field
    private LocalDate force_data; //执行日期
    @Field
    private String reference_number; //文号
    @Field
    private Integer formulation_organ;    //制定机关(发布部门)
    @Field
    private Integer legal_nature; //法律性质（效力级别）
    @Field
    private String content; //具体内容
    @Field
    private String content_file_url; //文件链接

    public Regulation(String title, LocalDate publish_date, LocalDate force_data, String reference_number, Integer formulation_organ, Integer legal_nature, String content, String content_file_url) {
        this.title = title;
        this.publish_date = publish_date;
        this.force_data = force_data;
        this.reference_number = reference_number;
        this.formulation_organ = formulation_organ;
        this.legal_nature = legal_nature;
        this.content = content;
        this.content_file_url = content_file_url;
    }
}
