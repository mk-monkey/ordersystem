package com.mkmonkey.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mkmonkey.sell.Bo.OrderDetail;
import com.mkmonkey.sell.enums.OrderStatusEnum;
import com.mkmonkey.sell.enums.PayStatusEnum;
import com.mkmonkey.sell.utils.EnumUtil;
import com.mkmonkey.sell.utils.serializer.Date2Longserializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Class Name: orderDTO
 * @Description: 内部传输订单详情
 * @Company bgy:  MK monkey
 * @create: 2018-02-13 12:57
 **/
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //订单 id
    private String orderId;
    //买家姓名
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //  买家地址
    private String buyerAddress;
    //买家微信 openID
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态,默认为下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    //更新时间
//    @JsonSerialize(using = Date2Longserializer.class)
    private Date createTime;
    //创建时间
//    @JsonSerialize(using = Date2Longserializer.class)
    private Date updateTime;
    // 商品列表
    List<OrderDetail> orderDetailList;

    @JsonInclude
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);

    }
    @JsonInclude
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
