<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans" style="height: 100%;">
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:set var="basePath" value="<%=basePath %>" scope="session"></c:set>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <script src="${basePath}/js/common/jquery-2.1.0.js"></script>
    <link href="${basePath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/media/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <sitemesh:write property='head'/>
</head>
<body style="height: 100%;">
<div class="page-container row-fluid" style="height: 100%;">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar nav-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <ul class="page-sidebar-menu">
            <li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <li class="start ">
                <a href="index.html">
                    <i class="icon-home"></i>
                    <span class="title">Dashboard</span>
                </a>
            </li>
            <li class="active ">
                <a href="javascript:;">
                    <i class="icon-table"></i>
                    <span class="title">Form Stuff</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
                <ul class="sub-menu">
                    <li class="active">
                        <a href="form_layout.html">
                            Form Layouts</a>
                    </li>
                    <li>
                        <a href="form_samples.html">
                            Advance Form Samples</a>
                    </li>
                    <li>
                        <a href="form_component.html">
                            Form Components</a>
                    </li>
                </ul>
            </li>
            <li class="">
                <a href="javascript:;">
                    <i class="icon-briefcase"></i>
                    <span class="title">Pages</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="page_timeline.html">
                            <i class="icon-time"></i>
                            Timeline</a>
                    </li>
                    <li>
                        <a href="page_coming_soon.html">
                            <i class="icon-cogs"></i>
                            Coming Soon</a>
                    </li>
                    <li>
                        <a href="page_blog.html">
                            <i class="icon-comments"></i>
                            Blog</a>
                    </li>
                </ul>
            </li>
            <li class="last ">
                <a href="charts.html">
                    <i class="icon-bar-chart"></i>
                    <span class="title">Visual Charts</span>
                </a>
            </li>
        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN PAGE -->
    <div class="page-content" style="height: 100%;">
        <div class="content_head">
            <sitemesh:write property='title'/>
        </div>
        <div class="content_body">
            <sitemesh:write property='body'></sitemesh:write>
        </div>
    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->
<script src="${basePath}/media/js/bootstrap.min.js"></script>
<script src="${basePath}/media/js/app.js"></script>
<script>
    jQuery(document).ready(function () {
        // initiate layout and plugins
        App.init();
    });
</script>
</body>
</html>