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
                <li class="active">用户管理</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">用户信息列表</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <c:if test="${userlist == null}">
                            <h3>${msg}</h3>
                        </c:if>
                        <c:if test="${userlist != null}">
                            <%--<table id="userlist-table" class="table table-striped table-bordered" cellspacing="0" width="100%">--%>
                            <table id="userlist-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>操作</th>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>联系电话</th>
                                    <th>注册时间</th>
                                    <th>当前状态</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${userlist}" var="itr">
                                <tr>
                                <td>
                                    <div class="radio">
                                        <input class="icheck" type="checkbox" name="check" value="${itr.id}">
                                        <%--<input class="icheck" type="checkbox" checked="" name="check1">--%>
                                    </div>
                                </td>
                                <td>${itr.id}</td>
                                <td>${itr.name}</td>
                                <td>${itr.role.name}</td>
                                <td>${itr.telephone}</td>
                                <td>
                                    <fmt:formatDate value="${itr.registerTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                <td>
                                    <c:if test="${itr.status == 0}">未登录</c:if>
                                    <c:if test="${itr.status == 1}">已登录</c:if>
                                    <c:if test="${itr.status == -1}">无效</c:if>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
</section>


<jsp:include page="footer.jsp" />

<!--Page Level JS -->
<!--Table插件js引入，需要用到jquery-->
<script src="/assets/plugins/dataTables/js/jquery.dataTables.min.js"></script>
<script src="/assets/plugins/dataTables/js/dataTables.bootstrap.js"></script>
<script src="/assets/plugins/dataTables/extensions/Select/js/dataTables.select.js"></script>
<script src="/assets/plugins/dataTables/extensions/Buttons/js/dataTables.buttons.min.js"></script>
<script src="/assets/plugins/dataTables/extensions/Editor/js/dataTables.editor.min.js"></script>

<script src="/assets/plugins/dataTables/extensions/Buttons/js/buttons.flash.min.js"></script>
<!--<script src="/assets/plugins/dataTables/extensions/Buttons/js/jszip.min.js"></script>-->
<!--<script src="/assets/plugins/dataTables/extensions/Buttons/build/pdfmake.min.js"></script>-->
<!--<script src="/assets/plugins/dataTables/extensions/Buttons/build/vfs_fonts.js"></script>-->
<script src="/assets/plugins/dataTables/extensions/Buttons/js/buttons.html5.js"></script>
<script src="/assets/plugins/dataTables/extensions/Buttons/js/buttons.print.js"></script>

<script>
    $(document).ready(function() {
        //导航栏激活标识
        $('#user-management').addClass("open active");
        $('#user-management-list').addClass("active");
        //添加table插件
        $('#userlist-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            dom: 'Bfrtip',
            buttons: [
                {
                    text: 'My button',
                    action: function ( e, dt, node, config ) {
                        alert( 'Button activated' );
                    }
                },
                {
                    text: '导出CSV',
                    extend: 'csv'
                },
                {
                    text: '打印',
                    extend: 'print'
                },
//                'csv',
//                'print'
//                { extend: "create", editor: editor, text:'新建'},
//                { extend: "edit",   editor: editor, text:'修改' },
//                { extend: "remove", editor: editor, text:'删除' }
            ],
            select: true

        });
    });
</script>

</body>

</html>