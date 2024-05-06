package com.liugaorong.blogserver.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName blog_admin
 */
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String username;
    private String password;
    @Version
    private Integer version;
    @TableLogic
    private Integer isDeleted;
}