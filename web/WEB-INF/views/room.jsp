<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:layout>
    <jsp:attribute name="javascript">
        <script src="${pageContext.request.contextPath}/assets/js/room.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid" >
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">List Room</h3>
                    <div class="right">
                        <button id="btn-open-modal-new-form" type="button" data-toggle="modal" data-target="#modal-new-room"  class="btn btn-primary"><i class="lnr lnr-plus-circle"></i> New Room</button>
                    </div>
                </div>
                <div class="panel-body no-padding" style="display: block;">
                    <table id="tbl-list-room" class="table table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Room No.</th>
                            <th>Type</th>
                            <th>Price</th>
                            <th>image</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-md-6"><span class="panel-note"><i class="fa fa-clock-o"></i> All Rooms</span></div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="new-room.jsp"%>
        <script type="text/template" id="row-room-template">
            {{#each items}}
                <tr>
                    <td>{{id}}</td>
                    <td>{{number}}</td>
                    <td>{{type}}</td>
                    <td>$ {{price}}</td>
                    <td>{{image}}</td>
                    <td>
                        <button data-room-id="{{id}}" class="btn btn-edit-room btn-sm btn-info"><i class="lnr lnr-pencil"></i> Edit </button>
                        <button data-room-id="{{id}}" class="btn btn-delete-room btn-sm btn-danger"><i class="lnr lnr-trash"></i> Delete </button>
                    </td>
                </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>