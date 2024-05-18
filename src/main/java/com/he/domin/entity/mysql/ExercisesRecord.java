package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("exercises_record")
@Accessors(chain = true)
public class ExercisesRecord {
    /**
     * 答题记录id
     */
    @TableId
    private Integer id;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 题目id
     */
    @TableField(value = "exercises_id")
    private Integer exercisesId;
    /**
     * 用户回答
     */
    @TableField(value = "answer")
    private String answer;
    /**
     * 是否正确
     */
    @TableField(value = "is_correct")
    private Boolean isCorrect;
    /**
     * 本题得分
     */
    @TableField(value = "result_mark")
    private Integer resultMark;
}
