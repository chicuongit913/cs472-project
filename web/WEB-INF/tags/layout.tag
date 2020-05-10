<%@tag description="Lab 11 Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="javascript" fragment="true"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Servlet - Homepage - Cuong Nguyen - 611111</title>

        <link rel="icon" href="./assets/images/favicon-cc.png" type="image/x-icon" />

        <link href="./assets/libs/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
        <link href="./assets/css/main.css" type="text/css" rel="stylesheet" />

        <script src="./assets/libs/jquery/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" type="text/javascript"></script>
        <script src="./assets/libs/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="./assets/libs/template-js/template7.min.js" type="text/javascript"></script>
        <script src="./assets/js/main.js" type="text/javascript"></script>
    </head>
    <body>
        <!-- layout header -->
        <%@include file="/WEB-INF/fragments/header.jsp"%>

        <!-- layout body -->
        <main>
            <jsp:doBody/>
        </main>

        <!-- layout footer -->
        <%@include file="/WEB-INF/fragments/footer.jsp"%>

        <!-- layout extra JS depend on page -->
        <jsp:invoke fragment="javascript"/>
    </body>
</html>
