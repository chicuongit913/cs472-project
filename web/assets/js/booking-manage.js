"use strict";
$(document).ready(function () {
    getListBooking();
    $("#new-booking").on("submit",addNewBooking);
    $("#new-booking-modal").on("shown.bs.modal", function () {
       getListOfRoom();
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

    $("#checkOut").change(function (e) {
        let bookingData = {};
        bookingData.checkIn = $("#checkIn").val();
        bookingData.checkOut = $("#checkOut").val();
        validationForm(bookingData);
    })
});

function getListBooking() {
    $.ajax("http://127.0.0.1:8080/hotel/api/booking",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-booking tbody").html(generateListBooking(data));
    }).fail(function () {
        notification('error', 'Loading Booking Failed', 'Something went wrong! Please check the connection');
    });
}

function generateListBooking(data) {
    if(data.length) {
        let template = $("#row-booking-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<td> (empty) </td>";
    }
}

function addNewBooking(e) {
    e.preventDefault();
    let bookingData = getNewBookingData($(this));
    if (!validationForm(bookingData)) {
        return  false;
    }

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
        $("#new-booking").trigger("reset");
        notification('success', 'Booking Added', 'Successfully');
    }).fail(function () {
        notification('error', 'Booking Failed', 'Something went wrong! Please check the booking data');
    }).always(function() {
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

function notification(type, header, content) {
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

function validationForm(bookingData) {
    if (new Date(bookingData.checkOut) < new Date(bookingData.checkIn)) {
        notification('error', 'Check-out date invalid', 'Check-out date is later than check-in date');
        return false;
    }
}

function getListOfRoom() {
    $.ajax("http://127.0.0.1:8080/hotel/api/room",
        {
            type: "GET"
        }
    ).done(function (data) {
        initialRoomInputGroup(data);

    }).fail(function () {
        notification('error', 'Loading Rooms Failed', 'Something went wrong! Please check the connection');
    });
}

function generateListOfRoom(data) {
    if(data.length) {
        let template = $("#row-room-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<li><a href='#'>empty</a></li>";
    }
}

function initialRoomInputGroup(data) {
    const handleRoomSelection = (new Promise(function (resolve, reject) {
        const inputSearch = `
                            <input class="form-control" id="findRoom" type="text" placeholder="Search.."/>
                            <script type="text/template" id="row-room-template">
                                {{#each items}}
                                <li><a href="#">{{number}}</a></li>
                                {{/each}}
                            </script>`;
        const dropdownMenuFindRoom = $(".dropdown.find-room ul.dropdown-menu");
        dropdownMenuFindRoom.html("");
        dropdownMenuFindRoom.append(inputSearch);
        dropdownMenuFindRoom.append(generateListOfRoom(data));
        $("#findRoom").on("keyup", function() {
            let value = $(this).val().toLowerCase();
            $(".dropdown-menu li").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
        if ($(".dropdown.find-room ul.dropdown-menu li a").length > 0) {
            resolve(true);
        } else {
            reject(true);
        }
    }));
    handleRoomSelection.then(function (resolve) {
        if(resolve) {
            $(".dropdown.find-room ul.dropdown-menu li a").click(function(){
                const val = $(this).html();
                $("#roomNumber").val(val);
            });
        }
    }, function (rejectedResult) {
        if(rejectedResult) {}
        notification("error", "ERROR", "Loading room failed");
    });
}