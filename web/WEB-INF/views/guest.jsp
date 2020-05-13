<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:layout>
    <jsp:attribute name="javascript">
        <script src="./assets/js/guest.js" type="text/javascript"></script>
        <script src="./assets/js/klorofil-common.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="row" >
                <div class="col-12" >
                    <h1 id="homepage-header" class="display-4 pt-3 pb-3 float-left border-0">Guest</h1>
                    <button data-toggle="modal" data-target="#add-guest" class="btn btn-outline-info mt-4 btn-lg float-right">Create New Guest</button>
                </div>
            </div>
            <div class="row">
                <div class="col-12" >
                    <table id="tbl-list-guest" class="table">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Fist Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Date Of Birth</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="new-guest.jsp"%>
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
            </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>