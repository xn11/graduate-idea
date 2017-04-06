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

<jsp:include page="../header.jsp" />
</head>
<body>
<%--<h1>${user.name}</h1>--%>
<%--${error}--%>

<jsp:include page="navi.jsp" />
<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>组织机构列表</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">You are here:</span>
            <ol class="breadcrumb">
                <li><a href="home">主页</a>
                </li>
                <li>系统信息管理</li>
                <li class="active">组织机构列表</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">组织机构列表</h3>
                        <div class="actions pull-right">
                            <i class="fa fa-expand"></i>
                            <i class="fa fa-chevron-down"></i>
                            <i class="fa fa-times"></i>
                        </div>
                    </div>
                    <div class="panel-body">

                        <div id="tree" class="col-sm-11"></div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->
</section>



<jsp:include page="../footer.jsp" />

<!-- TreeView JS -->
<script src="/assets/plugins/treeview/bootstrap-treeview.js"></script>

<script>
    //导航栏激活标识
    $('#system-management').addClass("open active");
    $('#organization-list').addClass("active");

    $.ajax({
        url: "getRootOrgList",
        method: "post",
        success(data){
            $('#tree').treeview(
                {
                    data: data,
                    levels: 4,
//                        nodeIcon: "fa-circle-thin",
                    expandIcon: "fa fa-chevron-right",
                    collapseIcon: "fa fa-chevron-down",
                    showBorder: false,
                    showTags: true
                });
        },
        error(XMLHttpRequest, textStatus, errorThrown){
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    });

</script>

</body>

</html>
