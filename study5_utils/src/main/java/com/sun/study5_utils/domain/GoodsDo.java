package com.sun.study5_utils.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品类
 */
@Getter
@Setter
public class GoodsDo {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 商品图片
     */
    private String pic;

}
