<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:layout>
    <jsp:attribute name="javascript">
        <script src="${pageContext.request.contextPath}/assets/js/guest.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/klorofil-common.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">Guest List</h3>
                    <div class="right">
                        <button type="button" data-toggle="modal" data-target="#new-guest-modal"
                                class="btn btn-primary">
                            <i class="lnr lnr-plus-circle"></i>New Guest
                        </button>
                    </div>
                </div>
                <div class="panel-body no-padding" style="display: block;">
                    <table id="tbl-list-guest" class="table table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Fist Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Date Of Birth</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-md-6"><span class="panel-note"><i class="fa fa-clock-o"></i>All Guests</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="new-guest.jsp" %>
        <script type="text/template" id="row-guest-template">
            {{#each items}}
            <tr>
                <td>{{id}}</td>
                <td>{{firstName}}</td>
                <td>{{lastName}}</td>
                <td>{{address}}</td>
                <td>{{email}}</td>
                <td>{{phoneNumber}}</td>
                <td>{{dob}}</td>
                <td>
                    <button data-room-id="{{id}}" class="btn btn-sm btn-info"><i class="lnr lnr-pencil"></i>Edit
                    </button>
                    <button data-room-id="{{id}}" class="btn btn-sm btn-danger"><i class="lnr lnr-trash"></i>Delete
                    </button>
                </td>
            </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>