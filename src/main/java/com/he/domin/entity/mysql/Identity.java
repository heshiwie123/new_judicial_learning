package com.he.domin.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName(value = "identity")
@Accessors(chain = true)
public class Identity {
    @TableId(value = "id")
    private Integer id;
    @TableField(value = "name")
    private String name;
}
