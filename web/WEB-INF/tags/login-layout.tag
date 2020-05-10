<%@tag description="Lab 11 Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="javascript" fragment="true"%>

<!doctype html>
<html lang="en">

<!-- HEAD -->
<%@include file="/WEB-INF/fragments/head.jsp"%>
<!-- END HEAD -->

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <jsp:doBody/>
</div>

<!-- layout footer -->
<%@include file="/WEB-INF/fragments/footer.jsp"%>

<!-- Javascript -->
<%@include file="/WEB-INF/fragments/general-js.jsp"%>
<!-- layout extra JS depend on page -->
<jsp:invoke fragment="javascript"/>
</body>
</html>
