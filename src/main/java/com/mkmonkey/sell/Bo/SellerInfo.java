package com.mkmonkey.sell.Bo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Class Name: SellerInfo
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 08:51
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String id;
    private String username;
    private String password;
    private String openid;


}
