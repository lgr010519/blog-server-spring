package com.liugaorong.blogserver.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName blog_tags
 */
@Data
public class Tags implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String name;
    private String createTime = String.valueOf(new Date().getTime());
    private String updateTime = "0";
    private Integer articleNum = 0;
    private Integer status = 0;
    @Version
    private Integer version;
    @TableLogic
    private Integer isDeleted;
}