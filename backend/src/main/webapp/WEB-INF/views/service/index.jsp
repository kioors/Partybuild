<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>页面标题1
        <small>---小标题</small>
    </title>
</head>
<body>
<input type="hidden" id="basePath" value="${basePath}">
<div id="content">
    <div class="row-fluid">

        <div class="span12">

            <!-- BEGIN EXAMPLE TABLE PORTLET-->

            <div class="portlet box light-grey">

                <div class="portlet-body">
                    <div class="control-group">

                        <div class="controls">
                            <div class="control-group">

                                <div class="controls">

                                    <select class="span3 chosen" data-placeholder="Choose a Category" tabindex="1"
                                            id="status">

                                        <option value=""></option>

                                        <option value="Category 1">Category 1</option>

                                        <option value="Category 2">Category 2</option>

                                        <option value="Category 3">Category 5</option>

                                        <option value="Category 4">Category 4</option>

                                    </select>
                                    &nbsp;
                                    <input type="text" class="span3 m-wrap" placeholder="提示语..." id="username"/>
                                    &nbsp;
                                    <a href="#" class="btn green">查询<i class="m-icon-swapright m-icon-white"></i></a>
                                </div>

                            </div>


                        </div>

                    </div>
                    <table class="table table-striped table-bordered table-hover" id="tableList">

                        <thead>

                        <tr>

                            <th style="width:8px;"><input type="checkbox" class="group-checkable"
                                                          data-set="#tableList .checkboxes"/></th>
                            <th>id</th>
                            <th>name</th>
                            <th class="hidden-480">mobile</th>
                            <th class="hidden-480">password</th>

                        </tr>

                        </thead>

                        <tbody>

                        <tr class="odd gradeX">

                            <td></td>
                            <td>2</td>
                            <td>shuxer</td>

                            <td class="hidden-480"><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>


                            <td><span class="label label-success">Approved</span></td>

                        </tr>

                        <tr class="odd gradeX">

                            <td></td>
                            <td>2</td>
                            <td>looper</td>

                            <td class="hidden-480"><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>

                            <td><span class="label label-warning">Suspended</span></td>

                        </tr>

                        </tbody>

                    </table>

                </div>

            </div>

            <!-- END EXAMPLE TABLE PORTLET-->

        </div>

    </div>
</div>
<script src="${basePath}/js/service/tableDemo.js"></script>
<script>
    jQuery(document).ready(function () {
        // initiate layout and plugins
        TableManaged.init();
    });
</script>
</body>
</html>
