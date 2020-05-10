<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:layout>
    <jsp:attribute name="javascript">
        <script src="./assets/js/book.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="row" >
                <div class="col-12" >
                    <h1 id="homepage-header" class="display-4 pt-3 pb-3 float-left border-0">Book in our Collection</h1>
                    <button data-toggle="modal" data-target="#add-book" class="btn btn-outline-info mt-4 btn-lg float-right">Add new book</button>
                </div>
            </div>
            <div class="row">
                <div class="col-12" >
                    <table id="tbl-list-book" class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">ISBN</th>
                            <th scope="col">Book Title</th>
                            <th scope="col">Overdue Fee</th>
                            <th scope="col">Publisher</th>
                            <th scope="col">Date Published</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="add-book.jsp"%>
        <script type="text/template" id="row-book-template">
            {{#each items}}
                <tr>
                    <td>{{bookId}}</td>
                    <td>{{isbn}}</td>
                    <td>{{title}}</td>
                    <td>{{overdueFee}}</td>
                    <td>{{publisher}}</td>
                    <td>{{datePublished}}</td>
                </tr>
            {{/each}}
        </script>
    </jsp:body>
</template:layout>