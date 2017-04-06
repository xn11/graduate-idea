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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="../header.jsp" />

<!-- DataTables-->
<link rel="stylesheet" href="/assets/plugins/dataTables/css/dataTables.css">
<%--<link rel="stylesheet" href="/assets/plugins/dataTables/extensions/Buttons/css/buttons.dataTables.min.css">--%>
<link rel="stylesheet" href="/assets/plugins/dataTables/extensions/Select/css/select.dataTables.min.css">
<!--<link rel="stylesheet" href="plugins/dataTables/css/jquery.dataTables.min.css">-->

</head>
<body>

<jsp:include page="navi.jsp" />
<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>监管机构列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">用户管理</li>
                <li class="active">监管机构列表</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">监管机构列表</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <table id="regulators-list-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <%--<th>地址</th>--%>
                                    <th>联系人</th>
                                    <th>联系电话</th>
                                    <%--<th>邮箱</th>--%>
                                    <th>评分</th>
                                    <%--<th>备注</th>--%>
                                </tr>
                            </thead>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
</section>

<!-- Add regulators Form Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addModalLabel">新建监管机构</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">机构名称</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="name" placeholder="机构名称" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="address" placeholder="地址" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contact" class="col-sm-3 control-label">联系人</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="contact" placeholder="联系人" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="tel" class="form-control" id="telephone" placeholder="电话" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">邮箱</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="email" placeholder="邮箱">
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
                <button type="button" class="btn btn-primary" id="saveRegulators" onclick="add();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Form Modal -->

<!-- edit regulators Form Modal -->
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
                        <label for="e-name" class="col-sm-3 control-label">机构名称</label>
                        <div class="col-sm-7">
                            <input type="hidden" id="e-id">
                            <input type="text" class="form-control" id="e-name" placeholder="机构名称" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-address" class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="e-address" placeholder="地址" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-contact" class="col-sm-3 control-label">联系人</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="e-contact" placeholder="联系人" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-telephone" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="tel" class="form-control" id="e-telephone" placeholder="电话" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-email" class="col-sm-3 control-label">邮箱</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="e-email" placeholder="邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="e-score" class="col-sm-3 control-label">评分</label>
                        <div class="col-sm-7">
                            <input type="number" class="form-control" id="e-score" placeholder="评分" required="required">
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



<jsp:include page="../footer.jsp" />

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
    $('#regulators-list').addClass("active");
    let t;
    $(function() {
        t = $('#regulators-list-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            ajax:{
                "url":"/admin/getRegulatorsListMap"
            },
            columns:[
                {data: null},
                {data: "id"},
                {data: "name"},
                {data: "contact"},
                {data: "telephone"},
                {data: "score"}
            ],
            order: [[1, 'asc']],
            columnDefs:[
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                }
            ],
            dom: "<'row'<'col-xs-7'B><'col-xs-5'f>r>"+"t" +
            "<'row'<'col-xs-6'i><'col-xs-6'p>>",
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
                        let row = this.row(".selected").data();
                        $("#e-id").val(row.id);
                        $("#e-name").val(row.name);
                        $("#e-address").val(row.address);
                        $("#e-contact").val(row.contact);
                        $("#e-telephone").val(row.telephone);
                        $("#e-email").val(row.email);
                        $("#e-score").val(row.score);
                        $("#e-note").val(row.note);
                    }
                },
                {
                    text: '<button class="btn btn-danger btn-trans btn-disabled" disabled="disabled" id="delBtn">删除</button>',
                    type: "danger",
                    action: function () {
                        let rows = this.rows('.selected').data();
                        let n = rows.count();
                        if (n > 0) {
                            let flag = confirm("确定删除选中的" + n + "条记录么？");
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
            if (!$(this).is('.selected')) {
                activeButtons(["delBtn", "editBtn"]);
            }else if ($("tr.selected").length == 1) {
                disButtons(["delBtn", "editBtn"]);
            }
        });

        //双击事件
        t.on('dblclick.dt',"tr", function(e) {
            activeButtons(["delBtn", "editBtn"]);
            $("#editBtn").click();
        });

    });

    function edit() {
        let editJson = {
            "id": $("#e-id").val(),
            "name": $("#e-name").val(),
            "address": $("#e-address").val(),
            "contact": $("#e-contact").val(),
            "telephone": $("#e-telephone").val(),
            "email": $("#e-email").val(),
            "score": $("#e-score").val(),
            "note": $("#e-note").val()
        };
        $.ajax({
            url: "updateRegulators",
            method : "post",
            data: editJson,
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("更新成功!");
                    $("#editModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    //若有无选中行则按钮失效
                    if ($('tr.selected').length <= 0){
                        disButtons(["delBtn", "editBtn"]);
                    }
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
        let addJson = {
            "name": $("#name").val(),
            "address": $("#address").val(),
            "contact": $("#contact").val(),
            "telephone": $("#telephone").val(),
            "email": $("#email").val(),
            "note": $("#note").val()
        };
        $.ajax({
            url: "addRegulators",
            method : "post",
            data: addJson,
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("添加成功!");
                    clear();
                    $("#addModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    disButtons(["delBtn", "editBtn"]);
                }else{
                    alert("添加失败!");
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
            }
        });

    }

    function del(rows) {
        let data = [];
        for (let i = 0; i < rows.length; i++) {
            data.push(rows[i].id);
        }
        $.ajax({
            url: "delRegulators",
            method : "post",
            data: {
                data: data
            },
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("删除成功!");
                    t.api().ajax.reload();  //刷新数据
                    disButtons(["delBtn", "editBtn"]);
                }else {
                    alert("删除失败!");
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
            }
        });
    }
</script>

</body>

</html>