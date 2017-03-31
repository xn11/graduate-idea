<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />

<body>

<jsp:include page="navi.jsp" />
<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>用户管理</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="userlist">主页</a>
                </li>
                <%--<li>Pages</li>--%>
                <li class="active">账号设置</li>
                <li class="active">账号信息</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">账号信息</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <form>
                            <div class="form-group">
                                <label for="name">姓名</label>
                                <label id="name" class="form-control">${user.name}</label>
                            </div>
                            <div class="form-group">
                                <label for="phone">电话</label>
                                <label id="phone" class="form-control">${user.telephone}</label>
                            </div>
                            <div class="form-group">
                                <label for="registerTime">注册时间</label>
                                <label id="registerTime" class="form-control">${user.registerTime}</label>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
</section>


<jsp:include page="footer.jsp" />

</body>

</html>