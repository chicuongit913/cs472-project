"use strict";
$(document).ready(function () {
    getListBook();
    $("#add-new-book").on("submit",addNewBook);
});

function getListBook() {
    $.ajax("https://elibraryrestapi.herokuapp.com/elibrary/api/book/list",
{
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-book tbody").html(generateListBook(data));
    }).fail(function () {
        console.log("something went wrong!")
    });
}

function generateListBook(data) {
    if(data.length) {
        let template = $("#row-book-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<td> No Book on collection </td>";
    }
}

function addNewBook(e) {
    e.preventDefault();
    let bookData = getNewBookData($(this));
    let that = $(this);
    $.ajax("https://elibraryrestapi.herokuapp.com/elibrary/api/book/add",
{
            "crossDomain": true,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
                "cache-control": "no-cache"
            },
            "processData": false,
            "data": JSON.stringify(bookData),
            "dataType": "json"
        }
    ).done(function (data) {
        $("#tbl-list-book tbody").html(getListBook());
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        document.getElementById("add-new-book").reset();
    });
    return false;
}

function getNewBookData(that) {
    let bookDataArray = that.serializeArray();
    let bookData = {};
    $.map(bookDataArray, function(n, i){
        bookData[n['name']] = n['value'];
    });
    return bookData;
}
