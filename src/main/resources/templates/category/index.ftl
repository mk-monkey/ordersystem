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
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label for="exampleInputEmail1">商品名称</label>
                            <input type="text" name="categoryName" class="form-control"
                                   value="${(category.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">单价</label>
                            <input type="text" name="categoryType" class="form-control"
                                   value="${(category.categoryType)!''}"/>
                        </div>
                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default btn-danger"> 提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>