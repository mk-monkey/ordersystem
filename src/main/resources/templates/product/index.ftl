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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">商品名称</label>
                            <input type="text" name="productName" class="form-control"
                                   value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">单价</label>
                            <input type="text" name="productPrice" class="form-control"
                                   value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">库存</label>
                            <input type="text" name="productStock" class="form-control"
                                   value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">描述</label>
                            <input type="text" name="productDescription" class="form-control"
                                   value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">图片</label>
                            <img src="${(productInfo.productIcon)!''}" alt="">
                            <input type="text" name="productIcon" class="form-control"
                                   value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">类目</label>
                            <select name="categoryType">
                                <#list productCategoryList as productCategory>
                                    <option value="${productCategory.categoryType}"
                                    <#if (productInfo.categoryType)?? &&productInfo.categoryType==productCategory
                                    .categoryType>selected</#if>
                                    >
                                        ${productCategory
                                        .categoryName}</option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default btn-danger"> 提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>