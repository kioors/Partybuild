<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><sitemesh:write property='title'/></title>
    <!-- Bootstrap CSS -->
    <link href="${ctx}/css/main.css" rel="stylesheet">
    <sitemesh:write property='head'/>
</head>
<body>
<div>
    <header class="navbar navbar-gitlab with-horizontal-nav">
        <div class="container-fluid">
            <div class="header-content">
                <div class="header-logo">
                    <a class="home" title="Dashboard" id="logo" href="/"
                       style="display: inline-block;line-height: 50px">
                        <img src="/images/logo.png">
                    </a>
                    <h1 class="title">
                        <span>驾嗨商户</span>
                    </h1>
                </div>
                <div class="title-container">
                    <div class="nav-control scrolling-tabs-container">
                        <div class="fade-left">
                            <i class="fa fa-angle-left"></i>
                        </div>
                        <div class="fade-right">
                            <i class="fa fa-angle-right"></i>
                        </div>
                        <ul class="nav-links scrolling-tabs">
                            <li class="home active"><a title="Overview" class="shortcuts-tree"
                                                       href="/admin"><span> 首 页 </span></a></li>
                            <li class=""><a href="/garage/order"><span> 订单 </span></a></li>
                            <li class=""><a href="/garage/info"><span> 维修厂 </span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="hidden-sm hidden-xs"></li>
                        <li>
                            <a class="shortcuts-todos" href="/dashboard/todos">
                                <i class="fa fa-check-circle fa-fw"></i>
                                <span class="badge todos-count"> 1 </span>
                            </a>
                        </li>
                        <li class="header-user dropdown">
                            <a class="header-user-dropdown-toggle" data-toggle="dropdown" href="/libing">
                                <img width="26" height="26" class="header-user-avatar"
                                     src="http://www.gravatar.com/avatar/0a038e43ae05f1d1456fab2329d618fd?s=52&amp;d=identicon">
                                <i class="fa fa-caret-down"></i>
                            </a>
                            <div class="dropdown-menu-nav dropdown-menu-align-right">
                                <ul>
                                    <li>
                                        <a class="profile-link" aria-label="Profile" data-user="libing" href="/libing">Profile</a>
                                    </li>
                                    <li>
                                        <a aria-label="Settings" href="/profile">Settings</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a class="sign-out-link" aria-label="Sign out" rel="nofollow"
                                           data-method="delete" href="/logout">Sign out</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    <div class="container-fluid">
        <sitemesh:write property='body'/>
    </div>
</div>
</body>
</html>