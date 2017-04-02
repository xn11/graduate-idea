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
                        <form id="form">
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
</section>


<jsp:include page="footer.jsp" />

<script>
    $("#submit").click(function() {
        modifyPwd();
    });

    function checkPwd() {
        var oldPwd = $("#oldPassword").val();
        var actualPwd = "<c:out value='${user.password}'/>";
        console.log("oldpwd: " + oldPwd);
        console.log("actualPwd: " + actualPwd);
        if (oldPwd != actualPwd) {
            alert("旧密码错误， 请重新输入");
            $("#oldPassword").val("");
            return false;
        }
        var newPwd = $("#newPassword").val();
        var newPwd2 = $("#newPassword2").val();

        if (newPwd != newPwd2) {
            alert("两次输入的密码不一致，请重新输入");
            $("#newPassword").val("");
            $("#newPassword2").val("");
            return false;
        }
        return true;
    }

    function modifyPwd() {
        if (!checkPwd()) return;
        var newPwd = $("#newPassword").val();
        $.ajax({
            url : "modifyPassword",
            method : "post",
            data : {
                newPwd : newPwd
            },
            success : function(result) {
                if (result.resultCode == "NORMAL") {
                    alert("密码修改成功");
                } else {
                    alert("未知错误，请稍后重试");
                }
            }
        });
    }

</script>

</body>

</html>