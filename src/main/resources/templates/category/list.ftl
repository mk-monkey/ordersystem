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
                                类目 id
                            </th>
                            <th>
                                名字
                            </th>
                            <th>
                                type
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                修改时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                <#list categoryList  as category>
                <tr>
                    <td>
                        ${category.categoryId}
                    </td>
                    <td>
                        ${category.categoryName}
                    </td>
                    <td>
                        ${category.categoryType}
                    </td>
                    <td>
                        ${category.createTime}
                    </td>
                    <td>
                        ${category.updateTime}
                    </td>
                    <td>
                        <a href="/sell//seller/category/index?categoryId=${category.categoryId}">修改</a>
                    </td>
                    <td>
                        <a href="/sell//seller/category/cancel?categoryId=${category.categoryId}">取消</a>
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
            <#-- <div class="col-md-12 column">
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
             </div>-->
            </div>
        </div>
    </div>
</div>

</body>
</html>