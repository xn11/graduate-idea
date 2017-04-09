<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>已发预警列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">你的位置:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li class="active">预警</li>
                <li class="active">已发预警列表</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">已发预警列表</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>

                    <div class="panel-body">
                        <table id="warning-list-table" class="table hover" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>企业客户</th>
                                    <th>预警类型</th>
                                    <th>严重等级</th>
                                    <th>状态</th>
                                    <th>发起人</th>
                                    <th>发送时间</th>
                                    <%--<th>负责人</th>--%>
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


<!-- Add warning Form Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addModalLabel">新建预警</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="a-company" class="col-sm-3 control-label">企业客户</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="a-company" required="required">
                                <option value="" selected>请选择</option>
                                <c:if test="${companyList != null}">
                                    <c:forEach items="${companyList}" var="itr">
                                        <option value="${itr.id}">${itr.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="a-type" class="col-sm-3 control-label">预警类型</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="a-type" required="required">
                                <option value="" selected>请选择</option>
                                <option value=1>数量预警</option>
                                <option value=2>价值预警</option>
                                <option value=3>监管预警</option>
                                <option value=0>其他预警</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="a-severity" class="col-sm-3 control-label">严重等级</label>
                        <div class="col-sm-7">
                            <input type="number" class="form-control" id="a-severity" placeholder="严重等级(0-最低，10-最高)" required="required" min=0 max=10>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="a-receivers" class="col-sm-3 control-label">通知人员</label>
                        <div class="col-sm-7">
                            <select class="form-control" multiple="multiple" id="a-receivers" required="required">
                                <option value="0" selected>全体人员</option>
                                <c:if test="${userList != null}">
                                    <c:forEach items="${userList}" var="itr">
                                        <option value="${itr.id}">${itr.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="a-note" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" id="a-note"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveBtn" onclick="add();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- End Form Modal -->

<!-- check warning Form Modal -->
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="checkModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editModalLabel">详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <input type="hidden" id="warningId">
                    <div class="form-group" id="system-auto">
                        <label for="system" class="col-sm-3 control-label">发起方</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="system" value="系统自动">
                        </div>
                    </div>
                    <div  id="sender-div">
                    <div class="form-group">
                        <label for="sender" class="col-sm-3 control-label">发起人</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="sender" readonly="readonly">
                        </div>
                        <label for="senderRole" class="col-sm-2 control-label">角色</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="senderRole" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="senderTel" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="senderTel" readonly="readonly">
                        </div>
                    </div>
                    </div>
                    <div class="form-group">
                        <label for="timestamp" class="col-sm-3 control-label">预警时间</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="timestamp" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="severity" class="col-sm-3 control-label">严重等级</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="severity" readonly="readonly">
                        </div>
                        <label for="type" class="col-sm-2 control-label">预警类型</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="type" readonly="readonly">
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
                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label">预警处理状态</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="status" readonly="readonly">
                        </div>
                    </div>
                    <div id="handler-div">
                    <div class="form-group">
                        <label for="handler" class="col-sm-3 control-label">负责人</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="handler" readonly="readonly">
                        </div>
                        <label for="handlerRole" class="col-sm-2 control-label">角色</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="handlerRole" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="handlerTel" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="handlerTel" readonly="readonly">
                        </div>
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
                <button type="button" class="btn btn-primary" id="e-saveUser" onclick="cancel();">取消预警</button>
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
    $('#warning-management').addClass("open active");
    $('#send-warning-list').addClass("active");

    let t;
    $(()=>{
        <%--let userList = <%=session.getAttribute("userList")%>;--%>
        <%--let companyList = <%=session.getAttribute("companyList")%>;--%>

        t = $('#warning-list-table').dataTable({
            "language": {
                "url": "/assets/lang/datatable_CN.json"
            },
            ajax:{
                url:"/user/getSendWarningListMap"
            },
            columns:[
                {data: null},
                {data: "company"},
                {data: "type"},
                {data: "severity"},
                {data: "status"},
                {data: "sender"},
                {data: "timestamp"}
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
                        return data.name;
                    }
                },
                {
                    "targets": 5,
                    "render": function(data, type, row){
                        return data.name;
                    }
                }
            ],
            dom: "<'row'<'col-xs-7'B><'col-xs-5'f>r>"+"t" +
            "<'row'<'col-xs-6'i><'col-xs-6'p>>",
            buttons: [
                {
                    text: '<button class="btn btn-success btn-trans" data-toggle="modal" data-target="#addModal" id="addBtn">新建</button>',
//                    action:function () {
//                        if (null == userList || null == companyList) {
//                            getUserAndCompanyList();
//                        }
//                    }
                },
                {
                    text: '<button class="btn btn-info btn-trans btn-disabled" data-toggle="modal" data-target="#checkModal" disabled="disabled" id="checkBtn">查看</button>',
                    action: function () {
                        if (this.row(".selected").count() != 1){
                            disButtons(["checkBtn"]);
                            return;
                        }
                        let row = this.row(".selected").data();

                        if (null == row.sender) {
                            $("#system-auto").show();
                            $("#sender-div").hide();
                        }else {
                            $("#system-auto").hide();
                            $("#sender-div").show();
                            $("#sender").val(row.sender.name);
                            $("#senderRole").val(row.sender.role);
                            $("#senderTel").val(printNull(row.sender.telephone));
                        }

                        $("#warningId").val(row.id);
                        $("#timestamp").val(row.timestamp);
                        $("#severity").val(row.severity);
                        $("#type").val(row.type);
                        $("#status").val(row.status);
                        $("#company").val(row.company.name);
                        $("#companyId").val(row.company.id);
                        $("#contact").val(printNull(row.company.contact));
                        $("#contactTel").val(printNull(row.company.telephone));

                        if (null == row.handler) {
                            $("#handler-div").hide();
                        }else {
                            $("#handler-div").show();
                            $("#handler").val(row.handler.name);
                            $("#handlerRole").val(row.handler.role);
                            $("#handlerTel").val(printNull(row.handler.telephone));
                        }

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
        t.on('dblclick.dt',"tr", function() {
            activeButtons(["checkBtn"]);
            $("#checkBtn").click();
        });

    });

    function add() {
        let addJson = {
            company: $("#a-company").val(),
            type: $("#a-type").val(),
            severity: $("#a-severity").val(),
            receivers:$("#a-receivers").val(),
            note:$("#a-note").val(),
        };
        $.ajax({
            url: "/user/addWarning",
            method : "post",
            data: addJson,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {
                    alert("发送成功!");
                    clear();
                    t.api().ajax.reload();  //刷新数据
                    disButtons(["checkBtn"]);
                }else{
                    alert("发送失败!");
                }
            },
            error(XMLHttpRequest, textStatus, errorThrown){
                handleAjaxError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    }

    function cancel() {
        let finishJson = {
            warningId: $("#warningId").val(),
            status: 3,
            note: $("#note").val()
        };

        $.ajax({
            url: "/user/handleWarning",
            method : "post",
            data: finishJson,
            async:false,//异步加载
            success: function (result) {
                if (result.resultCode == "NORMAL") {

                    alert("已取消该预警!");
                    $("#checkModal").modal("hide");
                    t.api().ajax.reload();  //刷新数据
                    //若有无选中行则按钮失效
                    if ($('tr.selected').length <= 0){
                        disButtons(["checkBtn"]);
                    }
                }else{
                    alert("取消预警失败，请稍后重试！");
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