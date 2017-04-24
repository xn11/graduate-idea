<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>待处理通知</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">通知</li>
                <li class="active">待处理通知</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">待处理通知</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <table id="notice-list-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>通知类型</th>
                                    <th>企业客户</th>
                                    <th>审批人</th>
                                    <th>状态</th>
                                    <th>通知时间</th>
                                    <th>备注</th>
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

<!-- check warning Form Modal -->
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="checkModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <input type="hidden" id="noticeId">
                    <div class="form-group">
                        <label for="type" class="col-sm-3 control-label">通知单类型</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="type" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="timestamp" class="col-sm-3 control-label">时间</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="timestamp" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="company" class="col-sm-3 control-label">企业客户</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="company" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contact" class="col-sm-3 control-label">企业联系人</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="contact" readonly="readonly">
                        </div>
                        <label for="contactTel" class="col-sm-2 control-label">联系方式</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="contactTel" readonly="readonly">
                        </div>
                    </div>
                    <div id="offline" class="form-group">
                        <label for="contractId" class="col-sm-3 control-label">合同编号</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="contractId" readonly="readonly">
                        </div>
                        <label for="contractLoan" class="col-sm-2 control-label">贷款金额</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="contractLoan" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label">通知单状态</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="status" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="director" class="col-sm-3 control-label">审批人</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="director" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" id="note"></textarea>
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
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="resubmitBtn" onclick="resubmit();">重新提交</button>
                <button type="button" class="btn btn-primary" id="sendBtn" onclick="send();">发送出质单</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Form Modal -->



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
    $('#notice-management').addClass("open active");
    $('#handle-notice-list').addClass("active");

    let t;
    $(()=>{
        <%--let userList = <%=session.getAttribute("userList")%>;--%>
        <%--let companyList = <%=session.getAttribute("companyList")%>;--%>

        t = $('#notice-list-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            ajax:{
                url:"/user/getHandleNoticeListMap"
            },
            columns:[
                {data: null},
                {data: "type"},
                {data: "contract"},
                {data: "director"},
                {data: "status"},
                {data: "timestamp"},
                {data: "note"}
            ],
            order: [[6, 'desc']],    //默认排序列（desc降序，asc升序）
            columnDefs:[
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                },
                {
                    "targets": 1,
                    "render": function(data, type, row){
                        return data;
                    }
                },
                {
                    "targets": 2,
                    "render": function(data, type, row){
                        return data.company.name;
                    }
                },
                {
                    "targets": 3,
                    "render": function(data, type, row){
                        return data.name;
                    }
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

                        if ("退回" == row.status) {
                            $("#resubmitBtn").show();
                            $("#sendBtn").hide();
                            $("#offline").hide();
                        }else {
                            $("#resubmitBtn").hide();
                            $("#sendBtn").show();
                            $("#offline").show();

                            $("#contractId").val(row.contract.id);
                            $("#contractId").val(row.contract.loan);
                        }

                        $("#noticeId").val(row.id);
                        $("#type").val(row.type);
                        $("#timestamp").val(row.timestamp);
                        $("#company").val(row.contract.company.name);
                        $("#contact").val(printNull(row.contract.company.contact));
                        $("#contactTel").val(printNull(row.contract.company.telephone));
                        $("#status").val(row.status);
                        $("#director").val(row.director.name);
                        $("#note").val(printNull(row.note));

                        let gages = row.gages;
                        $(".gages-div").remove();
                        $("#gage-list-input").val("");
                        if (null != gages && 0 < gages.length) {
                            let i = 1;
                            for (x of gages) {
                                $("#gage-list").after("<div class='form-group gages-div'>" +
                                    "<div class='col-sm-3'><input type='text' class='form-control' readonly='readonly' value=" + i +"></div>" +
                                    "<div class='col-sm-7'><input type='text' class='form-control' readonly='readonly' value=" + (x.gage.name + " X  " + x.quantity) +"></div>" +
                                    "</div>");
                            }
                        }else{
                            $("#gage-list-input").val("暂无");
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
        t.on('dblclick.dt',"tr", function() {
            activeButtons(["checkBtn"]);
            $("#checkBtn").click();
        });

    });

    function finish() {
        let finishJson = {
            warningId: $("#warningId").val(),
            status: 2,
            note: $("#note").val()
        };

        $.ajax({
            url: "/user/handleWarning",
            method : "post",
            data: finishJson,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("标记成功!");
                    $("#checkModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    //若有无选中行则按钮失效
                    if ($('tr.selected').length <= 0){
                        disButtons(["checkBtn"]);
                    }
                }else{
                    alert("标记失败，请稍后重试！");
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