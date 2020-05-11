<%--
  Created by IntelliJ IDEA.
  User: vtrang
  Date: 5/10/20
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:layout>
    <jsp:attribute name="javascript">
        <script src="./assets/js/booking-manage.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="row" >
                <div class="col-12" >
                    <h1 id="homepage-header" class="display-4 pt-3 pb-3 float-left border-0">Booking</h1>
                    <button data-toggle="modal" data-target="#add-book" class="btn btn-outline-info mt-4 btn-lg float-right">New Booking</button>
                </div>
            </div>
            <div class="row">
                <div class="col-12" >
                    <table id="tbl-list-booking" class="table">
                        <thead>
                        <tr>
                            <th scope="col">Confirm#</th>
                            <th scope="col">Room#</th>
                            <th scope="col">Guest</th>
                            <th scope="col">Check in</th>
                            <th scope="col">Check out</th>
                            <th scope="col">Status</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="new-booking.jsp"%>
        <script type="text/template" id="row-booking-template">
            {{#each items}}
            <tr>
                <td>{{id}}</td>
                <td>{{roomNumber}}</td>
                <td>{{guestID}}</td>
                <td>{{checkIn}}</td>
                <td>{{checkOut}}</td>
                <td>{{status}}</td>
            </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>
