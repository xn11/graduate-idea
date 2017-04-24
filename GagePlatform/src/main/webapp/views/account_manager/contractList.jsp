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
        <h1>质押合同列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">业务信息</li>
                <li class="active">质押合同列表</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">质押合同列表</h3>
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
                                    <th>合同编号</th>
                                    <th>企业客户</th>
                                    <th>协办</th>
                                    <th>合同期限</th>
                                    <th>贷款金额</th>
                                    <th>状态</th>
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

<!-- check contract and its gage list Form Modal -->
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
                        <label for="id" class="col-sm-3 control-label">合同编号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="company" class="col-sm-3 control-label">企业客户</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="company" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="time" class="col-sm-3 control-label">合同期限</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="time" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="loan" class="col-sm-3 control-label">贷款金额</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="loan" readonly="readonly">
                        </div>
                        <label for="status" class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="status" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" id="note"></textarea>
                                <%--<input type="text" class="form-control" id="note" readonly="readonly">--%>
                        </div>
                    </div>

                    <hr>
                    <div id="gage-list" class="form-group">
                        <label class="col-sm-3 control-label">质押品清单：</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="gage-list-input" readonly="readonly">
                        </div>
                    </div>

                </form>

                <%--<hr />
                <h5>质押品清单</h5>
                <table id="gages-table" class="table table-bordered" cellspacing="0" width="80%">
                    <thead>
                    <tr>
                        <th>存货名称</th>
                        <th>数量</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="put-in-storage" onclick="storage();">入库</button>
                <button type="button" class="btn btn-primary" id="save-note" onclick="save();">保存</button>
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
    $('#business-info-management').addClass("open active");
    $('#contract-list').addClass("active");

    let t;
    $(function() {
        t = $('#staff-list-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            ajax:{
                "url":"/account_manager/getContractListMap"
            },
            columns:[
                {data: null},
                {data: "id"},
                {data: "company"},
                {data: "accountManager"},
                {data: "fromDate"},
                {data: "loan"},
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
                    "render": function(data, type, row) {
                        return data.name;
                    },
                    "targets": 2
                },
                {
                    "render": function(data, type, row) {
                        return data.name;
                    },
                    "targets": 3
                },
                {
                    "render": function(data, type, row) {
                        return data + " ~ " + row.toDate;
                    },
                    "targets": 4
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
                        $("#company").val(row.company.name);
                        $("#time").val(row.fromDate + " ~ " + row.toDate);
                        $("#status").val(row.status);
                        $("#loan").val(row.loan);
                        $("#note").val(row.note);

                        let gages = row.contractGages;
//                        $("#gages-table tbody").empty();
                        $(".gages-div").remove();
                        $("#gage-list-input").val("");
                        if (null != gages && 0 < gages.length) {
                            for (x of gages) {
                                /*$("#gages-table tbody").appendChild("<tr>" +
                                    "<td>" + x.gage.name + "</td>" +
                                    "<td>" + x.quantity + "</td>" +
                                    "<td>" + x.note + "</td>" +
                                    "</tr>");*/

                                $("#gage-list").after("<div class='form-group gages-div'>" +
                                    "<label class='col-sm-3 control-label'>存货品种</label>" +
                                    "<div class='col-sm-3'><input type='text' class='form-control' readonly='readonly' value=" + x.gage.name +"></div>" +
                                    "<label class='col-sm-2 control-label'>质押数量</label>" +
                                    "<div class='col-sm-3'><input type='text' class='form-control' readonly='readonly' value=" + x.quantity +"></div>" +
                                    "</div>");
                            }
                        }else{
                            $("#gage-list-input").val("暂无");
                        }

                        //未入库且有质押物，则可以入库操作
                        if (row.status == "未入库" && gages.length > 0){
                            $("#put-in-storage").show();
                            $("#save-note").hide();
                        }else{
                            $("#put-in-storage").hide();
                            $("#save-note").show();
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

    function storage() {
        let n = $('.gages-div').length;
        let flag = confirm("确定向本部门主任发送合同中" + n + "种质押物入库的审批请求么？");
        let direvtor_id = "";
        if (!flag) {
            direvtor_id = prompt('请输入审批人用户名(默认为本部门主管)：', '');
            if(null == direvtor_id){
                return;
            }else if(direvtor_id == ""){
                alert("审批人用户名不可为空！")
                return;
            }
        }

        /*let n = $('.gages-div').length;
        let flag = confirm("确定要将" + n + "种质押物入库么？");
        if (!flag) {
            return;
        }*/

        let data = {
            "id": $("#id").val(),
            "note": $("#note").val(),
            "direvtor_uid": direvtor_id
        };
        $.ajax({
            url: "storageContract",
            method : "post",
            data: data,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("审批申请已发送!");
                    $("#checkModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    //若有无选中行则按钮失效
                    if ($('tr.selected').length <= 0){
                        disButtons(["checkBtn"]);
                    }
                }else{
                    alert(result.message);
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                handleAjaxError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    }

    function save() {
        let data = {
            "id": $("#id").val(),
            "note": $("#note").val()
        };
        $.ajax({
            url: "updateContract",
            method : "post",
            data: data,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("保存成功!");
                    $("#checkModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    //若有无选中行则按钮失效
                    if ($('tr.selected').length <= 0){
                        disButtons(["checkBtn"]);
                    }
                }else{
                    alert("保存失败！");
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                handleAjaxError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    }

</script>

</body>

</html>