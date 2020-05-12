"use strict";
$(document).ready(function () {
    getListBooking();

    $("#new-booking").on("submit",addNewBooking);
    $("#findRoom").on("keyup", function() {
        let value = $(this).val().toLowerCase();
        $(".dropdown-menu li").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
    $(".dropdown.find-room ul.dropdown-menu li a").click(function(){
        const val = $(this).html();
        $("#roomNumber").val(val);
    });

    $("#searchGuest").on("keyup", function() {
        let value = $(this).val().toLowerCase();
        $(".dropdown-menu li").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
    $(".dropdown.search-guest ul.dropdown-menu li a").click(function(){
        const val = $(this).html();
        $("#guestID").val(val);
    });
});

function getListBooking() {
    $.ajax("http://127.0.0.1:8080/hotel/api/booking",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-booking tbody").html(generateListBooking(data));
    }).fail(function () {
        console.log("something went wrong!")
    });
}

function generateListBooking(data) {
    if(data.length) {
        let template = $("#row-booking-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<td> No Book on collection </td>";
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
    $.ajax("http://127.0.0.1:8080/hotel/api/booking",
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
        nofitication('success', 'Booking Added', 'Successfully');
    }).fail(function () {
        console.log("something went wrong!")
        nofitication('error', 'Booking Failed', 'Something went wrong!');
    }).always(function() {
        document.getElementById("new-booking").reset();
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

function nofitication(type, header, content) {
    toastr.options.closeButton = true;
    toastr.options.closeMethod = 'fadeOut';
    toastr.options.closeDuration = 300;
    toastr.options.closeEasing = 'swing';
    toastr.options.newestOnTop = false;
    toastr.options.positionClass = 'toast-bottom-right';

    switch (type) {
        case 'info': toastr.info(content, header); break;
        case 'success': toastr.success(content, header); break;
        case 'warning': toastr.warning(content, header); break;
        case 'error': toastr.error(content, header); break;
    }
}
