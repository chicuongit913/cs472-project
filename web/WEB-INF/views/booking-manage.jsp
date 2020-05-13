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
        <script src="./assets/js/klorofil-common.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">List Booking</h3>
                    <div class="right">
                        <button id="btn-open-modal-new-form" type="button" data-toggle="modal" data-target="#new-booking-modal"  class="btn btn-primary"><i class="lnr lnr-plus-circle"></i> New Booking</button>
                    </div>
                </div>
                <div class="panel-body no-padding" style="display: block;">
                    <table id="tbl-list-booking" class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Confirm#</th>
                            <th scope="col">Room#</th>
                            <th scope="col">Guest</th>
                            <th scope="col">Check in</th>
                            <th scope="col">Check out</th>
                            <th scope="col">Total Night</th>
                            <th scope="col">Total Price</th>
                            <th scope="col"></th>
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
                <td>{{numberOfNight}}</td>
                <td>{{totalPrice}}$</td>
                <td>
                    <button data-booking-id="{{id}}" class="btn btn-edit-booking btn-sm btn-info"><i class="lnr lnr-pencil"></i> Edit </button>
                    <button data-booking-id="{{id}}" class="btn btn-delete-booking btn-sm btn-danger"><i class="lnr lnr-trash"></i> Delete </button>
                </td>
            </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>
