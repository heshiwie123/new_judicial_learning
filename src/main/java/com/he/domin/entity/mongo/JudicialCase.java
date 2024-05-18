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
public class JudicialCase {
    @Id
    private String id;
    @Field
    private Integer contract_type;   //合同类型
    @Field
    private Integer formulation_organ;   //制定机关(发布部门)
    @Field
    private Integer legal_nature;   //法律性质（效力级别）
    @Field
    private LocalDate publish_date;   //发布日期
    @Field
    private LocalDate force_date;   //执行日期
    @Field
    private String title;   //标题
    @Field
    private String content;   //具体内容
    @Field
    private String content_file_url; //文件链接

    public JudicialCase(Integer contract_type, Integer formulation_organ, Integer legal_nature, LocalDate publish_date, LocalDate force_date, String title, String content, String content_file_url) {
        this.contract_type = contract_type;
        this.formulation_organ = formulation_organ;
        this.legal_nature = legal_nature;
        this.publish_date = publish_date;
        this.force_date = force_date;
        this.title = title;
        this.content = content;
        this.content_file_url = content_file_url;
    }
}
