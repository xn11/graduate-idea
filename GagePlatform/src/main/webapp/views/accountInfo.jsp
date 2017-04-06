<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>账号信息</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">个人设置</li>
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
                        <form class="form-horizontal form-border">
                            <div class="form-group">
                                <label for="name" class="control-label col-sm-3">用户名</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="name" readonly="readonly" value="${user.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="role" class="control-label col-sm-3">角色</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="role" readonly="readonly" value="${user.role.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="telephone" class="col-sm-3 control-label">电话</label>
                                <div class="col-sm-6">
                                    <input type="tel" class="form-control" id="telephone" placeholder="电话" value="${user.telephone}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="registerTime" class="control-label col-sm-3">注册时间</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="registerTime" readonly="readonly" value="<fmt:formatDate value="${user.registerTime}" type="both" />">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastLoginTime" class="control-label col-sm-3">上次登录时间</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="lastLoginTime" readonly="readonly" value="${user.lastLoginTime}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastChangeTime" class="control-label col-sm-3">上次账户变更时间</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="lastChangeTime" readonly="readonly" value="${user.lastChangeTime}">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <button type="button" id="saveBtn" class="btn btn-primary btn-block">保 存</button>
                                </div>
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

<script>
    //导航栏激活标识
    $('#settings').addClass("open active");
    $('#settings-info').addClass("active");

    $(()=>{
        accountInfo();
    });

</script>