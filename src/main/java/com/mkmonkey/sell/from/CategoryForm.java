package com.mkmonkey.sell.from;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @Class Name: CategoryForm
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 08:07
 **/
@Data
public class CategoryForm {
    //类目 id
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
}
