<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: xn
  Date: 2017/3/26
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>光大押品管理——用户登录</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!-- Favicon -->
    <%--<link rel="shortcut icon" href="<c:url value="/assets/img/favicon.ico"/>" type="image/x-icon">--%>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Fonts  -->
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/simple-line-icons.css">
    <!-- CSS Animate -->
    <link rel="stylesheet" href="/assets/css/animate.css">
    <!-- Custom styles for this theme -->
    <link rel="stylesheet" href="/assets/css/main.css">
    <link rel="stylesheet" href="/assets/css/gage.css">
    <!-- Feature detection -->
    <script src="/assets/js/vendor/modernizr-2.6.2.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/assets/js/vendor/html5shiv.js"></script>
    <script src="/assets/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- 	预填充 :cookie(userid——ui_pre)
		中文解码：URLDecoder.decode(cookies[i].getName(),"utf-8");-->
<%
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    String uid_pre = "";
    if (null != cookies) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            String name = URLDecoder.decode(cookies[i].getName(), "utf-8");
            if (name.equals("uid")) {
                uid_pre = URLDecoder.decode(cookie.getValue(), "utf-8");
                break;
            }
        }
    }
%>

<section class="container animated fadeInUp">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="login-wrapper">
                <header>
                    <div class="brand">
                        <img src="/assets/img/logo.png" alt="光大银行">
                    </div>
                </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            用户登录
                        </h3>
                    </div>
                    <div class="panel-body">
                        <p></p>
                        <form class="form-horizontal" role="form" action="login" method="post">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" class="form-control" id="uid" name="uid" placeholder="用户名 / 用户ID"
                                           required="required" autocomplete="on" value="<%=uid_pre%>">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="密码" required="required">
                                    <i class="fa fa-lock"></i>
                                    <%--<a href="javascript:void(0)" class="help-block">Forgot Your Password?</a>--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <c:if test="${error != null}">
                                        <p class="error-msg">${error}</p>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <%--<a href="login" class="btn btn-primary btn-block">登 录</a>--%>
                                    <button type="submit" class="btn btn-primary btn-block" name="action" value="login">
                                        登 录
                                    </button>
                                    <hr/>
                                    <button type="submit" class="btn btn-default btn-block" name="action"
                                            value="logout">签 退
                                    </button>
                                    <%--<a href="pages-sign-up.html" class="btn btn-default btn-block">Not a member? Sign--%>
                                    <%--Up</a>--%>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<jsp:include page="footer.jsp" />

</body>

</html>
