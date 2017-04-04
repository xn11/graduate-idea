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

<jsp:include page="../header.jsp" />
</head>
<body>
<%--<h1>${user.name}</h1>--%>
<%--${error}--%>

<jsp:include page="navi.jsp" />
<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>Blank Page</h1>
        <div class="breadcrumb-wrapper hidden-xs">
            <span class="label">You are here:</span>
            <ol class="breadcrumb">
                <li><a href="index.html">Dashboard</a>
                </li>
                <li>Pages</li>
                <li class="active">Blank Page</li>
            </ol>
        </div>
    </div>
    <section id="main-content" class="animated fadeInUp">

    </section>
</section>
<!--main content end-->
</section>

<!--header and navi end-->

<h1>Hello!</h1>


<jsp:include page="../footer.jsp" />


</body>

</html>
