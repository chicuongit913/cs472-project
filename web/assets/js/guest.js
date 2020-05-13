"use strict";
$(document).ready(function () {
    getGuestList();
    $("#new-guest").on("submit", addNewGuest);
    $("#new-booking-modal").on("shown.bs.modal", function () {
        getGuestList();
    });
    $("#new-guest [type='reset']").on("click", function () {
        $("#new-guest")[0].reset();
        //document.getElementById("new-guest").reset();
    });
});

function getGuestList() {
    $.ajax("api/guest",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-guest tbody").html(generateGuestList(data));
    }).fail(function () {
        console.log("something went wrong!")
    });
}

function generateGuestList(data) {console.log(data);
    if (data.length) {
        for(let i=0;i<data.length;i++){
            if(data[i]["dob"]){
                data[i]["dob"] = data[i]["dob"].substr(0,12);
            }
        }
        let template = $("#row-guest-template").html();
        let compiledTemplate = Template7.compile(template);
        return compiledTemplate({"items": data});
    } else {
        return "<td> No Guest on collection </td>";
    }
}

function addNewGuest(e) {
    e.preventDefault();
    let guestData = getNewGuestData($(this));
    let that = $(this);
    let progressBar = that.find(".modal-footer .progress");
    let submitButton = that.find("button[type='submit']");
    submitButton.text("Saving...");
    progressBar.removeClass("hide");
    $.ajax("api/guest",
        {
            "crossDomain": true,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
                "cache-control": "no-cache"
            },
            "processData": false,
            "data": JSON.stringify(guestData),
            "dataType": "json"
        }
    ).done(function (data) {
        $("#tbl-list-book tbody").html(getGuestList());
        nofitication('success', 'Guest Added', 'Successfully');
    }).fail(function () {
        console.log("something went wrong!")
        nofitication('error', 'Guest Failed', 'Something went wrong!');
    }).always(function () {
        document.getElementById("new-guest").reset();
        progressBar.addClass("hide");
        submitButton.text("Save");
    });
    return false;
}

function getNewGuestData(that) {
    let guestDataArray = that.serializeArray();
    let guestData = {};
    $.map(guestDataArray, function (n, i) {
        guestData[n['name']] = n['value'];
    });
    return guestData;
}

function nofitication(type, header, content) {
    toastr.options.closeButton = true;
    toastr.options.closeMethod = 'fadeOut';
    toastr.options.closeDuration = 300;
    toastr.options.closeEasing = 'swing';
    toastr.options.newestOnTop = false;
    toastr.options.positionClass = 'toast-bottom-right';

    switch (type) {
        case 'info':
            toastr.info(content, header);
            break;
        case 'success':
            toastr.success(content, header);
            break;
        case 'warning':
            toastr.warning(content, header);
            break;
        case 'error':
            toastr.error(content, header);
            break;
    }
}