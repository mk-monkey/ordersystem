package com.mkmonkey.sell.Bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkmonkey.sell.enums.ProductStatusEnum;
import com.mkmonkey.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Class Name: ProductInfo
 * @Description: 商品详情
 * @Company bgy:  MK monkey
 * @create: 2018-01-25 21:42
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    //商品 id
    @Id
    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态 0整除 1下架
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    //更新时间
    //@JsonSerialize(using = Date2Longserializer.class)
    private Date createTime;
    //创建时间
    //@JsonSerialize(using = Date2Longserializer.class)
    private Date updateTime;
    //类目编号
    private Integer categoryType;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
