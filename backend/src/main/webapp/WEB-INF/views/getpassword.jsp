<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:set var="basePath" value="<%=basePath %>" scope="session"></c:set>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>忘记密码</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/iconfont.css"/>
</head>
<body>
    <img src="${basePath}/images/bg.png" alt="" id="bg_img"/>

    <div id="content">
        <div id="main_tit">驾嗨后台管理系统</div>

        <div id="login">
            <div class="psd_div">
                <input type="tel" name="telNo" id="telNo" value="" placeholder="请输入手机号" maxlength="11"/>
            </div>
            <div class="getbox">
                <input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" name="" id="" value="" placeholder="请输入验证码" maxlength="10"/>
                <input type="button" value="获取验证码" id="getCode"/>
            </div>
            <div class="psd_div">
                <input type="text" placeholder="设置密码(6位以上)" onkeyup="value=value.replace(/[^\w\.\-\/]/ig,'')" maxlength="16"/>
            </div>
            <div class="psd_div">
                <input type="text" placeholder="新密码确认(6位以上)" onkeyup="value=value.replace(/[^\w\.\-\/]/ig,'')" maxlength="16"/>
            </div>

            <input type="button" value="确认修改" class="sure"/>

        </div>

    </div>
</div>

</body>
</html>
