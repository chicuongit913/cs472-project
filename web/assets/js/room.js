"use strict";
$(document).ready(function () {
    getListBooking();
    $("#new-booking").on("submit",addNewBooking);
});

function getListBooking() {
    $.ajax("/hotel/api/room",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-room tbody").html(generateListRoom(data));
    }).fail(function () {
        console.log("something went wrong!")
    });
}

function generateListRoom(data) {
    if(data.length) {
        let template = $("#row-room-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<td> No Room on collection </td>";
    }
}

function addNewBooking(e) {
    e.preventDefault();
    let bookingData = getNewBookingData($(this));
    let that = $(this);
    let progressBar = that.find(".modal-footer .progress");
    let submitButton = that.find("button[type='submit']");
    submitButton.text("Saving...");
    progressBar.removeClass("hide");
    $.ajax("http://127.0.0.1:8080/hotel/booking-api",
        {
            "crossDomain": true,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
                "cache-control": "no-cache"
            },
            "processData": false,
            "data": JSON.stringify(bookingData),
            "dataType": "json"
        }
    ).done(function (data) {
        $("#tbl-list-book tbody").html(getListBooking());
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        document.getElementById("new-booking").reset();
        console.log("Always");
        progressBar.addClass("hide");
        submitButton.text("Save");
    });
    return false;
}

function getNewBookingData(that) {
    let bookDataArray = that.serializeArray();
    let bookData = {};
    $.map(bookDataArray, function(n, i){
        bookData[n['name']] = n['value'];
    });
    return bookData;
}
