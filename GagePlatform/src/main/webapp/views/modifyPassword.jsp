<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>修改密码</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <%--<li>Pages</li>--%>
                <li class="active">个人设置</li>
                <li class="active">修改密码</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">修改密码</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal form-border">
                            <div class="form-group">
                                <label for="oldPassword">原密码</label>
                                <input id="oldPassword" type="password" class="form-control" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="newPassword">新密码</label>
                                <input id="newPassword" type="password" class="form-control" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="newPassword2">新密码确认</label>
                                <input id="newPassword2" type="password" class="form-control required="required"">
                            </div>
                            <button id="submit" class="btn btn-primary btn-block">
                                确认修改
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
