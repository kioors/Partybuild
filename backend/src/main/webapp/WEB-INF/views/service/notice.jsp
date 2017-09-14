<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>页面标题1
        <small>----小标题</small>
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
                                    <input type="text" class="span3 m-wrap" placeholder="公告标题" id="title"/>&nbsp;&nbsp;
                                    <select class="span3" data-placeholder="公告状态" tabindex="1" id="status">
                                        <option value=""></option>
                                        <option value="Category 1">未发布</option>
                                        <option value="Category 2">已发布</option>
                                    </select>&nbsp;&nbsp;
                                    <a href="javascript:;" onclick="refreshList();" class="btn green">查询 <i
                                            class="m-icon-swapright m-icon-white"></i></a>&nbsp;&nbsp;
                                    <a href="javascript:;" onclick="refreshList();" class="btn green"><i
                                            class="icon-plus"></i> 新增公告</a>&nbsp;&nbsp;
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover" id="tableList"></table>
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
