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

            <!-- NAVBAR -->
                <%@include file="/WEB-INF/fragments/top-nav.jsp"%>
            <!-- END NAVBAR -->

            <!-- LEFT SIDEBAR -->
                <%@include file="/WEB-INF/fragments/left-sidebar.jsp"%>
            <!-- END LEFT SIDEBAR -->

            <!-- MAIN -->
            <div class="main">

                <!-- MAIN CONTENT -->
                <div class="main-content">
                    <jsp:doBody/>
                </div>
                <!-- END MAIN CONTENT -->

            </div>
            <!-- END MAIN -->

        </div>

        <div class="clearfix"></div>

        <!-- layout footer -->
        <%@include file="/WEB-INF/fragments/footer.jsp"%>

        <!-- Javascript -->
        <%@include file="/WEB-INF/fragments/general-js.jsp"%>
        <!-- layout extra JS depend on page -->
        <jsp:invoke fragment="javascript"/>
    </body>
</html>
