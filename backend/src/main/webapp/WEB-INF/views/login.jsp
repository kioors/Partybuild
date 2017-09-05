<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:set var="basePath" value="<%=basePath %>" scope="session"></c:set>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>网上支部我的家-后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/iconfont.css"/>
    <script src="${basePath}/js/common/jquery-2.1.0.js"></script>
    <script src="${basePath}/js/login/login.js"></script>
</head>
<body>
<img src="${basePath}/images/bg.png" alt="" id="bg_img"/>

<div id="content">
    <div id="main_tit">网上支部我的家-后台管理系统</div>
    <input type="hidden" id="basePath" value="${basePath}"/>
    <form id="loginForm" method="POST" action="<c:url value='/dologin'/>">
    <div id="login">

        <div class="iput_div">
            <i class="iconfont icon-userface"></i>
            <input type="text" name="mobile" id="mobile" value="" placeholder="请输入用户名"/>
            <input type="hidden" id="usernameWarn" value="请输入用户名" class="font_red"/>
        </div>
        <div class="iput_div">
            <i class="iconfont icon-mima"></i>
            <input type="password" name="password" id="password" value="" placeholder="请输入登录密码" maxlength="16"/>
            <input type="hidden" id="passwordWarn" value="请输入登录密码" class="font_red"/>
        </div>

        <a href="getpassword.html">忘记密码</a>

        <input type="button" id="loginBtn" value="登录" class="save"/>
    </div>
    </form>
    <div id="Copyright">
        Copyright©2016 KingYon LTD. All Right Reserved 版权所有：成都金翼致远科技有限公司 蜀ICP备15000388号-1
    </div>

</div>

</body>
</html>
