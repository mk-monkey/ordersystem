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
                                商品 id
                            </th>
                            <th>
                                名称
                            </th>
                            <th>
                                图片
                            </th>
                            <th>
                                单价
                            </th>
                            <th>
                                库存
                            </th>
                            <th>
                                描述
                            </th>
                            <th>
                                介绍
                            </th>
                            <th>
                                类目
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

                <#list productInfoPage.content as productInfo>
                <tr>
                    <td>
                        ${productInfo.productId}
                    </td>
                    <td>
                        ${productInfo.productName}
                    </td>
                    <td>
                        <img height="100" width="100" src="${productInfo.productIcon}" alt="">
                    </td>
                    <td>
                        ${productInfo.productPrice}
                    </td>
                    <td>
                        ${productInfo.productStock}
                    </td>
                    <td>
                        ${productInfo.productDescription}
                    </td>
                    <td>
                        微信
                    </td>
                    <td>
                        ${productInfo.categoryType}
                    </td>
                    <td>
                        ${productInfo.createTime}
                    </td>
                    <td>
                        <a href="/sell//seller/product/index?productId=${productInfo.productId}">修改</a>
                    </td>
                    <td>
                    <#if productInfo.getProductStatusEnum().code==0>
                        <a href="/sell//seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                    <#else >
                        <a href="/sell//seller/product/on_sale?productId=${productInfo.productId}">上架</a>
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
                <li><a href="/sell//seller/product/list?page=${currebtPage-1}&size=${size}">上一页</a></li>
            </#if>
            <#list 1..productInfoPage.getTotalPages() as index>
                <#if currebtPage==index>
                <li class="disabled"><a href="/sell//seller/product/list?page=${index}&size=${size}">${index}</a></li>
                <#else >
                <li><a href="/sell//seller/product/list?page=${index}&size=${size}">${index}</a></li>
                </#if>
            </#list>
            <#if currebtPage gte productInfoPage.getTotalPages()>
                <li class="disabled"><a>下一页</a></li>
            <#else >
                <li><a href="/sell//seller/product/list?page=${currebtPage+1}&size=${size}">下一页</a></li>
            </#if>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>