<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../header.jsp" />
</head>
<body>

<jsp:include page="navi.jsp" />

<!--main content start-->
<jsp:include page="../accountInfo.jsp" />
<!--main content end-->

</section>


<jsp:include page="../footer.jsp" />

<script>
    //导航栏激活标识
    $('#settings').addClass("open active");
    $('#settings-info').addClass("active");

//    $(()=>{
        accountInfo();
//    });

</script>

</body>

</html>