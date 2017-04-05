<%--
  Created by IntelliJ IDEA.
  User: xn
  Date: 2017/3/27
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<section id="main-wrapper" class="theme-default">
    <header id="header">
        <!--logo start-->
        <div class="brand">
            <a href="home" class="logo">
                <img src="/assets/img/logo_m.png" alt="光大银行">
            </a>
        </div>
        <!--logo end-->
        <%--<ul class="nav navbar-nav navbar-left">
            <li class="toggle-navigation toggle-left">
                <button class="sidebar-toggle" id="toggle-left">
                    <i class="fa fa-bars"></i>
                </button>
            </li>
            <!--profile toggle-->
            &lt;%&ndash;<li class="toggle-profile hidden-xs">
                <button type="button" class="btn btn-default" id="toggle-profile">
                    <i class="icon-user"></i>
                </button>
            </li>&ndash;%&gt;

            <!--search box-->
            &lt;%&ndash;<li class="hidden-xs hidden-sm">
                <input type="text" class="search" placeholder="Search project...">
                <button type="submit" class="btn btn-sm btn-search"><i class="fa fa-search"></i>
                </button>
            </li>&ndash;%&gt;
        </ul>--%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown profile hidden-xs">
                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="meta">
                            <%--<span class="avatar">
                                <img src="/assets/img/profile.jpg" class="img-circle" alt="">
                            </span>--%>
                            <i class="icon-user"></i>
                        <span class="text">${user.name}</span>
                        <span class="caret"></span>
                        </span>
                </a>
                <ul class="dropdown-menu animated fadeInRight" role="menu">
                    <%--<li>
                        <span class="arrow top"></span>
                        <h5>
                            <span>80%</span>
                            <small class="text-muted">Profile complete</small>
                        </h5>
                        <div class="progress progress-xs">
                            <div class="progress-bar progress-bar" style="width: 80%">
                            </div>
                        </div>
                    </li>
                    <li class="divider"></li>--%>
                    <li>
                        <a href="accountInfo">
                            <span class="icon"><i class="fa fa-user"></i></span>
                            账号信息
                        </a>
                    </li>
                    <%--<li>
                        <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-envelope"></i>
                                </span>账户安全</a>
                    </li>--%>
                    <li>
                        <a href="modifyPassword">
                            <span class="icon"><i class="fa fa-cog"></i></span>
                            修改密码
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="/logout">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>退出</a>
                    </li>
                </ul>
            </li>
            <li class="toggle-navigation toggle-left">
                <button class="sidebar-toggle" id="toggle-left">
                    <i class="fa fa-bars"></i>
                </button>
            </li>
            <li class="toggle-fullscreen hidden-xs">
                <button type="button" class="btn btn-default expand" id="toggle-fullscreen">
                    <i class="fa fa-expand"></i>
                </button>
            </li>

            <!--contact list toggle-->
            <%--<li class="toggle-navigation toggle-right">
                <button class="sidebar-toggle" id="toggle-right">
                    <i class="fa fa-indent"></i>
                </button>
            </li>--%>
        </ul>
    </header>

    <!--sidebar left start-->
    <aside class="sidebar sidebar-left">
        <!--profile-->
        <%--<div class="sidebar-profile">
            <div class="avatar">
                <img class="img-circle profile-image" src="assets/img/profile.jpg" alt="profile">
                <i class="on border-dark animated bounceIn"></i>
            </div>
            <div class="profile-body dropdown">
                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><h4>Mike Adams <span class="caret"></span></h4></a>
                <small class="title">Front-end Developer</small>
                <ul class="dropdown-menu animated fadeInRight" role="menu">
                    <li class="profile-progress">
                        <h5>
                            <span>80%</span>
                            <small>Profile complete</small>
                        </h5>
                        <div class="progress progress-xs">
                            <div class="progress-bar progress-bar-primary" style="width: 80%">
                            </div>
                        </div>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-user"></i>
                                </span>My Account</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-envelope"></i>
                                </span>Messages</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-cog"></i>
                                </span>Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="javascript:void(0);">
                                <span class="icon"><i class="fa fa-sign-out"></i>
                                </span>Logout</a>
                    </li>
                </ul>
            </div>
        </div>--%>

        <nav>
            <h5 class="sidebar-header">功能栏</h5>
            <ul class="nav nav-pills nav-stacked">
                <li>
                    <a href="home" title="Dashboard">
                        <i class="fa  fa-fw fa-tachometer"></i> 主页
                    </a>
                </li>
                <li class="nav-dropdown">
                    <a href="#"  title="system management">
                        <i class="fa  fa-fw fa-cogs"></i>系统信息管理
                    </a>
                    <ul class="nav-sub">
                        <li>
                            <a href="#" title="org management">
                                组织管理
                            </a>
                        </li>
                        <li>
                            <a href="#" title="log management">
                                日志管理
                            </a>
                        </li>
                        <li>
                            <a href="#" title="cofig management">
                                系统参数配置
                            </a>
                        </li>
                        <%--<li>
                            <a href="#" title="auth management">
                                权限管理
                            </a>
                        </li>--%>
                    </ul>
                </li>
                <li id="user-management" class="nav-dropdown">
                    <a href="#" title="user management">
                        <i class="fa  fa-fw  icon-users"></i> 用户管理
                    </a>
                    <ul class="nav-sub">
                        <li id="user-management-list">
                            <a href="userlist" title="user list">
                                用户信息列表
                            </a>
                        </li>
                        <li><a href="#" title="batch add">批量导入</a>
                        </li>
                        <li>
                            <a href="#" title="regulators management">
                                员工列表
                            </a>
                        </li>
                        <li id="regulators-list">
                            <a href="regulatorsList" title="regulators management">
                                监管机构列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-dropdown">
                    <a href="#" title="msg management">
                        <i class="fa  fa-fw fa-bell-o"></i> 通知管理
                    </a>
                    <ul class="nav-sub">
                        <li><a href="#" title="warning">预警</a>
                        </li>
                        <li><a href="#" title="info">公告</a>
                        </li>
                    </ul>
                </li>
                <li id="settings" class="nav-dropdown">
                    <a href="#" title="settings">
                        <i class="fa  fa-fw fa-edit"></i> 个人设置
                    </a>
                    <ul class="nav-sub">
                        <li  id="settings-info"><a href="accountInfo"title="info">账号信息</a>
                        </li>
                        <li  id="settings-password"><a href="modifyPassword" title="password">修改密码</a>
                        </li>
                    </ul>
                </li>
                <!--mail-->
                <%--<li class="nav-dropdown">
                    <a href="#" title="Mail">
                        <i class="fa fa-fw fa-envelope-o"></i> Mail
                        <span class="label label-primary label-circle pull-right">8</span>
                    </a>
                    <ul class="nav-sub">
                        <li>
                            <a href="mail-inbox.html" title="Mail Inbox">
                                Inbox
                            </a>
                        </li>
                        <li>
                            <a href="mail-compose.html" title="Mail Compose">
                                Compose Mail
                            </a>
                        </li>
                    </ul>
                </li>--%>
            </ul>
        </nav>
        <!--账户设置-->
        <%--<h5 class="sidebar-header">账户设置</h5>
        <div class="setting-list">
            <ul class="nav nav-pills nav-stacked">
                <li>
                    <a href="admin/home" title="Dashboard">
                        <i class="fa  fa-fw fa-tachometer"></i> 主页
                    </a>
                </li>
            &lt;%&ndash;<div class="row">
                <div class="col-xs-8">
                    <label for="check1" class="control-label">Share your status</label>
                </div>
                <div class="col-xs-4">
                    <input type="checkbox" class="js-switch" checked id="check1" />
                </div>
            </div>&ndash;%&gt;
        </div>--%>
    </aside>
    <!--sidebar left end-->



<!--Config demo-->
<%--<div id="config" class="config hidden-xs">
    <h4>Settings<a href="javascript:void(0)" class="config-link closed"><i class="icon-settings"></i></a></h4>
    <div class="config-swatch-wrap">
        <div class="row">
            <div class="col-xs-6">
                <ul class="options">
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-default">
                            <span class="header bg-white"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-dark">
                            <span class="header bg-dark"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-blue">
                            <span class="header bg-info"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-blue-full">
                            <span class="header bg-info"></span>
                            <span class="header bg-info"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-grey">
                            <span class="header bg-grey"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-grey-full">
                            <span class="header bg-grey"></span>
                            <span class="header bg-grey"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>

                </ul>
            </div>
            <div class="col-xs-6">
                <ul class="options">
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-dark-full">
                            <span class="header bg-dark"></span>
                            <span class="header bg-dark"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-green">
                            <span class="header bg-green"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-green-full">
                            <span class="header bg-green"></span>
                            <span class="header bg-green"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-red">
                            <span class="header bg-red"></span>
                            <span class="header bg-white"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-red-full">
                            <span class="header bg-red"></span>
                            <span class="header bg-red"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                    <li>
                        <div class="theme-style-wrapper" data-theme="theme-dark-blue-full">
                            <span class="header bg-dark-blue"></span>
                            <span class="header bg-dark-blue"></span>
                            <span class="nav bg-dark"></span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>--%>
<!--/Config demo-->