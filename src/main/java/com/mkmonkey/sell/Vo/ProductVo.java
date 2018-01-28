package com.mkmonkey.sell.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Data;

import java.util.List;

/**
 * @Class Name: ProductVo
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 18:47
 **/
@Data
public class ProductVo {

    @JsonProperty("name")//将catrgoryName返回前端后显示为 name
    private String catrgoryName;

    @JsonProperty("type")//将categortType返回前端后显示为 type
    private Integer categortType;

    @JsonProperty("foods")
    private List<ProductInofoVo> productInofoVoList;
}
