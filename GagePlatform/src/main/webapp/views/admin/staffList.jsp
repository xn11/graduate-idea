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
        <h1>员工列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">用户管理</li>
                <li class="active">员工列表</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">员工列表</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <table id="staff-list-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <%--<th>身份证号</th>--%>
                                    <%--<th>联系电话</th>--%>
                                    <th>入职时间</th>
                                    <th>职级</th>
                                    <th>职位</th>
                                    <th>组织部门</th>
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

<!-- check staff Form Modal -->
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="checkModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editModalLabel">详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="id" class="col-sm-3 control-label">工号</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="id" readonly="readonly">
                        </div>
                        <label for="name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="name" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idCard" class="col-sm-3 control-label">身份证号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="idCard" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-sm-3 control-label">电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="telephone" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="hireDate" class="col-sm-3 control-label">入职时间</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="hireDate" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="level" class="col-sm-3 control-label">职级</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="level" readonly="readonly">
                        </div>
                        <label for="post" class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="post" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="department" class="col-sm-3 control-label">部门</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="department" readonly="readonly">
                        </div>
                        <label for="organization" class="col-sm-2 control-label">组织机构</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="organization" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <%--<textarea class="form-control" id="note"></textarea>--%>
                                <input type="text" class="form-control" id="note" readonly="readonly">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
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
    $('#staff-list').addClass("active");

    let t;
    $(function() {
        t = $('#staff-list-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            ajax:{
                "url":"/admin/getStaffListMap"
            },
            columns:[
                {data: null},
                {data: "id"},
                {data: "name"},
                {data: "hireDate"},
                {data: "level"},
                {data: "post"},
                {data: "department"}
            ],
            order: [[1, 'asc']],
            columnDefs:[
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                },
                {
                    "render": function(data, type, row) {
                        return row.department.organization.name + data.name;
                    },
                    "targets": 6
                }
            ],
            dom: "<'row'<'col-xs-12 col-sm-7'B><'col-xs-12 col-sm-5'f>r>"+"t" +
            "<'row'<'hidden-xs col-sm-6'i><'col-xs-12 col-sm-6'p>>",
            buttons: [
                {
                    text: '<button class="btn btn-info btn-trans btn-disabled" data-toggle="modal" data-target="#checkModal" disabled="disabled" id="checkBtn">查看</button>',
                    action: function () {
                        if (this.row(".selected").count() != 1){
                            disButtons(["checkBtn"]);
                            return;
                        }
                        let row = this.row(".selected").data();
                        $("#id").val(row.id);
                        $("#name").val(row.name);
                        $("#idCard").val(printNull(row.idCard));
                        $("#telephone").val(printNull(row.telephone));
                        $("#hireDate").val(row.hireDate);
                        $("#level").val(row.level);
                        $("#post").val(row.post);
                        $("#department").val(row.department.name);
                        $("#organization").val(row.department.organization.name);
                        $("#note").val(printNull(row.note));
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
            select: 'single',
//            select: true,
            stateSave: true
        });

        //添加序号
        t.on( 'order.dt search.dt', function () {
            t.api(true).column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                cell.innerHTML = i+1;
            } );
        } ).api(true).draw();

        t.on('click.dt dblclick.dt', 'tr',function() {
            if (!$(this).is('.selected')) {
                activeButtons(["checkBtn"]);
            }else {
                disButtons(["checkBtn"]);
            }
        });

        //双击事件
        t.on('dblclick.dt',"tr", function(e) {
            activeButtons(["checkBtn"]);
            $("#checkBtn").click();
        });

    });

</script>

</body>

</html>