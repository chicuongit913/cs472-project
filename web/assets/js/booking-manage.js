"use strict";
let guests;
let rooms;

$(document).ready(function () {
    getListBooking();
    $("#new-booking").on("submit", addNewBooking);
    $("#new-booking-modal").on("shown.bs.modal", function () {
        getListOfRoom();
        getListOfGuest();
    });
    $("#checkOut").change(function () {
        let bookingData = {};
        bookingData.checkIn = new Date($("#checkIn").val());
        bookingData.checkOut = new Date($(this).val());
        validationForm(bookingData);
        let nights = Math.round((bookingData.checkOut.getTime() - bookingData.checkIn.getTime()) / (1000 * 3600 * 24))
        if (nights < 0) {
            nights = 0;
        } else if (nights === 0) {
            nights = 1;
        }
        $("#numberOfNight").val(nights);
    });
});

function getListBooking() {
    $.ajax("/hotel/api/booking",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-booking tbody").html(generateListBooking(data));
        $("button.btn-delete-booking").click(function () {
            const that = $(this);
            const tr = that.parents("tr");
            const tdId = tr.find("td")[0];
            const id = $(tdId).html();
            console.log(id);
        });
        $("button.btn-edit-booking").click(function () {
            const that = $(this);
            $("#new-booking-modal").modal("show");
        })
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
        return false;
    }
    delete bookingData.roomPrice;
    let that = $(this);
    let progressBar = that.find(".modal-footer .progress");
    let submitButton = that.find("button[type='submit']");
    submitButton.text("Saving...");
    progressBar.removeClass("hide");
    $.ajax("/hotel/api/booking",
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
        $("#generateGuestInfo").html("");
        notification('success', 'Booking Added', 'Successfully');
    }).fail(function () {
        notification('error', 'Booking Failed', 'Something went wrong! Please check the booking data');
    }).always(function () {
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
        case 'info':
            // toastr.info(content, header);
            break;
        case 'success':
            // toastr.success(content, header);
            break;
        case 'warning':
            // toastr.warning(content, header);
            break;
        case 'error':
            // toastr.error(content, header);
            break;
    }
}

function validationForm(bookingData) {
    if (bookingData.checkOut < bookingData.checkIn) {
        notification('error', 'Check-out date invalid', 'Check-out date is later than check-in date');
        return false;
    }
    return true;
}

function getListOfRoom() {
    $.ajax("/hotel/api/room",
        {
            type: "GET"
        }
    ).done(function (data) {
        initialInputGroup("findRoom", "row-room-template", "number", ".dropdown.find-room ul.dropdown-menu", data, "roomNumber");
        rooms = data;
    }).fail(function () {
        notification('error', 'Loading Rooms Failed', 'Something went wrong! Please check the connection');
    });
}

function getListOfGuest() {
    $.ajax("/hotel/api/guest",
        {
            type: "GET"
        }
    ).done(function (data) {
        initialInputGroup("searchGuest", "row-guest-template", "id", ".dropdown.search-guest ul.dropdown-menu", data, "guestID");
        guests = data;
    }).fail(function () {
        notification('error', 'Loading Rooms Failed', 'Something went wrong! Please check the connection');
    });
}

function generateListOfData(data, scripID) {
    if (data.length) {
        let template = $(scripID).html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<li><a href='#'>empty</a></li>";
    }
}

function initialInputGroup(inputId, scriptID, propertyMapping, dropdownMenuQuery, data, mappingField) {
    const inputSearch = `
                       <input class="form-control" id="${inputId}" type="text" placeholder="Search.."/>
                        <script type="text/template" id="${scriptID}">
                            {{#each items}}
                            <li><a href="#">{{${propertyMapping}}}</a></li>
                            {{/each}}
                        </script>`;
    const ulDropdownMenu = $(dropdownMenuQuery);
    ulDropdownMenu.html("");
    ulDropdownMenu.append(inputSearch);
    ulDropdownMenu.append(generateListOfData(data, `#${scriptID}`));
    $("#findRoom").on("keyup", function () {
        let value = $(this).val().toLowerCase();
        $(".dropdown-menu li").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
    $(dropdownMenuQuery + " li a").click(function () {
        const val = $(this).html();
        $(`#${mappingField}`).val(val);
        let componentID;
        if (mappingField === "roomNumber") {
            componentID = "#roomPrice";
        } else if (mappingField === "guestID") {
            componentID = "#generateGuestInfo";
        }
        generateDetailValue(val, componentID);
    });
}

function generateDetailValue(data, componentId) {
    if (componentId === "#roomPrice") {
        let room = rooms.filter(r => r.number === data).pop();
        $(componentId).val(room.price);
        let nights = $("#numberOfNight").val();
        if (room.price > 0 && nights > 0) {
            const totalPrice = parseInt(room.price) * parseInt(nights);
            $("#totalPrice").val(totalPrice);
        }
    } else {
        let guest = guests.filter(g => g.id === parseInt(data)).pop();
        $(componentId).html(`${guest.firstName} ${guest.lastName} || ${guest.phoneNumber}`);
    }
}