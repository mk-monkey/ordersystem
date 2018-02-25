<!DOCTYPE html>
<html lang="en">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-condensed table-bordered">
                        <thead>
                        <tr>
                            <th>
                                订单 id
                            </th>
                            <th>
                                姓名
                            </th>
                            <th>
                                手机号
                            </th>
                            <th>
                                地址
                            </th>
                            <th>
                                金额
                            </th>
                            <th>
                                订单状态
                            </th>
                            <th>
                                支付方式
                            </th>
                            <th>
                                支付状态
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>
                        ${orderDTO.orderId}
                    </td>
                    <td>
                        ${orderDTO.buyerName}
                    </td>
                    <td>
                        ${orderDTO.buyerPhone}
                    </td>
                    <td>
                        ${orderDTO.buyerAddress}
                    </td>
                    <td>
                        ${orderDTO.orderAmount}
                    </td>
                    <td>
                        ${orderDTO.getOrderStatusEnum().message}
                    </td>
                    <td>
                        微信
                    </td>
                    <td>
                        ${orderDTO.getPayStatusEnum().message}
                    </td>
                    <td>
                        ${orderDTO.createTime}
                    </td>
                    <td>
                        <a href="/sell//seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                    </td>
                    <td>
                    <#if orderDTO.orderStatus==0>
                        <a href="/sell//seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>

                    </#if>
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination  pull-right">
            <#if currebtPage lte 1>
                <li class="disabled"><a>上一页</a></li>
            <#else >
                <li><a href="/sell//seller/order/list?page=${currebtPage-1}&size=${size}">上一页</a></li>
            </#if>
            <#list 1..orderDTOPage.getTotalPages() as index>
                <#if currebtPage==index>
                <li class="disabled"><a href="/sell//seller/order/list?page=${index}&size=${size}">${index}</a></li>
                <#else >
                <li><a href="/sell//seller/order/list?page=${index}&size=${size}">${index}</a></li>
                </#if>
            </#list>
            <#if currebtPage gte orderDTOPage.getTotalPages()>
                <li class="disabled"><a>下一页</a></li>
            <#else >
                <li><a href="/sell//seller/order/list?page=${currebtPage+1}&size=${size}">下一页</a></li>
            </#if>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>