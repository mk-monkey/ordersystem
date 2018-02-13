package com.mkmonkey.sell.Bo;

import com.mkmonkey.sell.enums.OrderStatusEnum;
import com.mkmonkey.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Class Name: OrderMaster
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:02
 **/
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    //订单 id
    @Id
    private String orderId;
    //买家姓名
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //  买家地址
    private String buyerAddress;
    //买家危险 openID
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态,默认为下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
