package com.plxcc.admin.utils;

import lombok.Getter;

/**
 * @PackgeName: com.plxcc.admin.utils
 * @ClassName: StateEnums
 * @Author: plxc
 * Date: 2020/9/6 21:09
 * project name: blog
 * @Version:
 * @Description:状态的枚举
 */
@Getter
public enum  StateEnums {



    /**
     * 逻辑删除的状态
     */
    DELETED(1,"删除"),
    NOT_DELETED(0,"未删除")
    ;



    private Integer code;
    private String msg;
    StateEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
