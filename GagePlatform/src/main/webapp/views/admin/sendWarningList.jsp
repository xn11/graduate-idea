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
<jsp:include page="../sendWarningList.jsp" />
<!--main content end-->



</body>

</html>