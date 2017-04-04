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
        <h1>用户信息列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">用户管理</li>
                <li class="active">用户信息列表</li>
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
                        <%--<c:if test="${userlist == null}">
                            <h3>${msg}</h3>
                        </c:if>--%>
                        <%--<c:if test="${userlist != null}">--%>
                            <%--<table id="userlist-table" class="table table-striped table-bordered" cellspacing="0" width="100%">--%>
                            <table id="userlist-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>联系电话</th>
                                    <th>注册时间</th>
                                    <th>当前状态</th>
                                </tr>
                            </thead>

                            <%--<tbody>
                                <c:forEach items="${userlist}" var="itr">
                                <tr>
                                <td>
                                    <div class="radio">
                                        <input class="icheck" type="checkbox" name="check" value="${itr.id}">
                                        &lt;%&ndash;<input class="icheck" type="checkbox" checked="" name="check1">&ndash;%&gt;
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
                            </tbody>--%>
                        </table>
                        <%--</c:if>--%>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
</section>

<!-- Add user Form Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addModalLabel">新建用户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="uid" class="col-sm-3 control-label">工号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="uid" placeholder="工号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="password" placeholder="密码" value=8888>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="role" class="col-sm-3 control-label">角色</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="role">
                                <option value=0>系统管理员</option>
                                <option value=1 selected = "selected">客户经理</option>
                                <option value=2>公司部主任</option>
                                <option value=3>监管机构</option>
                                <%--<option value=4>监管员</option>--%>
                                <option value=5>授信执行人</option>
                                <option value=6>授信执行主任</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="tel" class="form-control" id="telephone" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" id="note"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveUser" onclick="add();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Form Modal -->

<!-- edit user Form Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editModalLabel">编辑信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="e-uname" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-7">
                            <input type="hidden" id="e-id">
                            <input type="text" class="form-control" id="e-uname" placeholder="用户名" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="e-password" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-role" class="col-sm-3 control-label">角色</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="e-role">
                                <option value=0>系统管理员</option>
                                <option value=1>客户经理</option>
                                <option value=2>公司部主任</option>
                                <option value=3>监管机构</option>
                                <%--<option value=4>监管员</option>--%>
                                <option value=5>授信执行人</option>
                                <option value=6>授信执行主任</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-telephone" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="tel" class="form-control" id="e-telephone" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-status" class="col-sm-3 control-label">用户状态</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="e-status">
                                <option value=0 selected = "selected">未登录</option>
                                <option value=1>已登录</option>
                                <option value=-1>无效</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" id="e-note"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="e-saveUser" onclick="edit();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Form Modal -->
<%--<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" class="form-control" id="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="position" placeholder="位置">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="salary" placeholder="薪资">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="start_date" placeholder="时间"
                           data-date-format="yyyy/mm/dd">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="office" placeholder="工作地点">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="extn" placeholder="编号">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>--%>



<jsp:include page="footer.jsp" />

<!--Page Level JS -->
<!--Table插件js引入，需要用到jquery-->
<script src="/assets/plugins/dataTables/js/jquery.dataTables.min.js"></script>
<%--<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>--%>
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

    //导航栏激活标识
    $('#user-management').addClass("open active");
    $('#user-management-list').addClass("active");
    var t;
    $(document).ready(function() {
        t = $('#userlist-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
//                data:data,
            ajax:{
                "url":"/admin/getUserListMap"
            },
            columns:[
                {data: null},
                {data: "id"},
                {data: "name"},
                {data: "role"},
                {data: "telephone"},
                {data: "registerTime"},
                {data: "status"}
            ],
            order: [[1, 'asc']],
            columnDefs:[
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                },
                {
                    "targets": 6,
                    "render": function(data, type, row){
                        switch (data){
                            case 0: return "未登录";
                            case 1: return "已登录";
                            case -1: return "无效";
                            default: return "error";
                        }
                    }
                }

            ],
            dom: "<'row'<'col-xs-7'B><'col-xs-5'f>r>"+"t" +
            "<'row'<'col-xs-6'i><'col-xs-6'p>>",
//                dom: 'Bfrtip',
            buttons: [
                {
                    text: '<button class="btn btn-success btn-trans" data-toggle="modal" data-target="#addModal" id="addBtn">新建</button>',
                },
                {
                    text: '<button class="btn btn-info btn-trans btn-disabled" data-toggle="modal" data-target="#editModal" disabled="disabled" id="editBtn">编辑</button>',
                    action: function () {
                        if (this.row(".selected").count() <= 0){
                            disButtons(["editBtn", "delBtn"]);
                            return;
                        }
                        var row = this.row(".selected").data();
                        $("#e-id").val(row.id);
                        $("#e-uname").val(row.name);
                        $("#e-password").val(row.password);
                        $("#e-telephone").val(row.telephone);
                        $("#e-note").val(row.note);
                        $("#e-status").val(row.status);

//                        $("#e-status").find("option[text="+row.status+"]").attr("selected",true);
//                        $("#e-role").find("option[text="+row.role+"]").attr("selected",true);
                        var selectVal = $("select#e-role option:contains("+row.role+")").val();
                        $("#e-role").val(selectVal);
                    }
                },
                {
                    text: '<button class="btn btn-danger btn-trans btn-disabled" disabled="disabled" id="delBtn">删除</button>',
                    type: "danger",
                    action: function () {
                        var rows = this.rows('.selected').data();
                        var n = rows.count();
                        if (n > 0) {
                            var flag = confirm("确定删除选中的" + n + "条记录么？");
                            if (flag) {
                                del(rows);
                            }
                        }
                    }
                },
                {
                    text: '导出',
                    extend: 'csv',
                    className:"btn btn-primary btn-trans"
                },
                {
                    text: '打印',
                    extend: 'print',
                    className:"btn btn-primary btn-trans"
                }
            ],
            select: true,
            stateSave: true
        });

        //添加序号
        t.on( 'order.dt search.dt', function () {
            t.api(true).column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                cell.innerHTML = i+1;
            } );
        } ).api(true).draw();

        t.on('click.dt dblclick.dt', 'tr',function(e) {
//            $(this).toggleClass('selected');
            if (!$(this).is('.selected')) {
                activeButtons(["delBtn", "editBtn"]);
            }else if ($("tr.selected").length == 1) {
                disButtons(["delBtn", "editBtn"]);
            }
        });

        //双击事件
        t.on('dblclick.dt',"tr", function(e) {
//            var data = table.$('input, select').serialize();
//            vat cnt = table.rows( { selected: true } ).count();
//            alert("The following data would have been submitted to the server: \n\n" + data.substr(0, 120) + '...');
//            $("#addModal").modal("show");
            activeButtons(["delBtn", "editBtn"]);
            $("#editBtn").click();

        });


    });

    //按钮失效
    function disButtons(btnIds){
        for (var i = 0; i < btnIds.length; i++) {
            var btn = $("#" + btnIds[i]);
            btn.attr("disabled", true);
            btn.addClass("btn-disabled");
        }
    }
    //激活按钮
    function activeButtons(btnIds){
        for (var i = 0; i < btnIds.length; i++) {
            var btn = $("#" + btnIds[i]);
            btn.attr("disabled", false);
            btn.removeClass("btn-disabled");
        }
    }

    function clear() {
        $(".form-control").val("");
    }

    function edit() {
        var editJson = {
            "id": $("#e-id").val(),
            "password": $("#e-password").val(),
            "role": $("#e-role").val(),
            "telephone": $("#e-telephone").val(),
            "note": $("#e-note").val(),
            "status": $("#e-status").val()
        };
        $.ajax({
            url: "updateUser",
            method : "post",
            data: editJson,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("更新成功!");
                    $("#editModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                }else{
                    alert("更新失败！");
                }
            },
            error:function(error) {
                console.log("error: " + error);
            }
        });
    }

    function add() {
        var addJson = {
            "uid": $("#uid").val(),
            "password": $("#password").val(),
            "role": $("#role").val(),
            "telephone": $("#telephone").val(),
            "note": $("#note").val()
        };
        $.ajax({
            url: "addUser",
            method : "post",
            data: addJson,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("添加成功!");
                    $("#addModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    disButtons(["delBtn", "editBtn"]);
                }else{
                    alert("添加失败!");
                }
            },
            error:function(error) {
                console.log("error: " + error);
            }
        });

    }

    function del(rows) {
        var data = [];
        for (var i = 0; i < rows.length; i++) {
            data.push(rows[i].id);
        }
        $.ajax({
            url: "delUsers",
            method : "post",
            data: {
                data: data
//                data: JSON.stringify(data)
            },
            async:false,//异步加载
//            traditional: true,///阻止深度序列化
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("删除成功!");
                    t.api().ajax.reload();  //刷新数据
                    disButtons(["delBtn", "editBtn"]);
//                showSuccess("data");
                }else {
                    alert("删除失败!");
                }
            },
            error:function(error) {
                console.log("error: " + error);
            }
        });
    }
</script>

</body>

</html>