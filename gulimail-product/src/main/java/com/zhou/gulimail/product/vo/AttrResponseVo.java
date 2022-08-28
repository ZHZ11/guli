package com.zhou.gulimail.product.vo;

import lombok.Data;

import java.util.List;

@Data
public class AttrResponseVo extends AttrVo {

    /**
     * 分类名称
     */
    private String catelogName;

    /**
     * 分组名称
     */
    private String groupName;

    private List<Long> catelogPath;
}
