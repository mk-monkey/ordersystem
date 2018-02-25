package com.mkmonkey.sell.Bo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Class Name: ProductCategory
 * @Description: 商品类目
 * @Company bgy:  MK monkey
 * @create: 2018-01-24 22:02
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    //类目 id
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
