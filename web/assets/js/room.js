"use strict";
let dropZoneUploadImage = false;
$(document).ready(function () {
    getListRoom();
    $("#form-new-room").on("submit",uploadImage);
    initUploadFile();
    $("#tbl-list-room").on("click", ".btn-edit-room", editRoom)
});

function getListRoom() {
    $("#tbl-list-room tbody").addClass("emptyBody");
    $("#tbl-list-room tbody").waitMe();
    $("#tbl-list-room tbody").html("");
    $.ajax("/hotel/api/room",
        {
            type: "GET"
        }
    ).done(function (data) {
        $("#tbl-list-room tbody").html(generateListRoom(data));
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        $("#tbl-list-room tbody").waitMe("hide");
        $("#tbl-list-room tbody").removeClass("emptyBody");
    });
}

function editRoom() {
    $("#tbl-list-room tbody").waitMe();
    let roomId = $(this).data("room-id");
    $.ajax("/hotel/api/room?room-id="+roomId,
        {
            type: "GET"
        }
    ).done(function (data) {
        console.log(data);
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        $("#tbl-list-room tbody").waitMe("hide");
        $("#tbl-list-room tbody").removeClass("emptyBody");
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

function addNewRoom() {

    let formRoom = $("#form-new-room");
    let roomData = getNewRoomData(formRoom);
    formRoom.find(".modal-body").waitMe();
    let submitButton = formRoom.find("button[type='submit']");
    submitButton.text("Saving...");
    $.ajax("/hotel/api/room",
        {
            "crossDomain": true,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
                "cache-control": "no-cache"
            },
            "processData": false,
            "data": JSON.stringify(roomData),
            "dataType": "json"
        }
    ).done(function (data) {
        $("#tbl-list-room tbody").html(getListRoom());
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        document.getElementById("form-new-room").reset();
        submitButton.text("Submit");
        $("#modal-new-room").modal("hide");
        formRoom.find(".modal-body").waitMe("hide");
        $("#room-image").removeClass("hide");
    });
}

function getNewRoomData(that) {
    let roomDataArray = that.serializeArray();
    let roomData = {};
    $.map(roomDataArray, function(n, i){
        roomData[n['name']] = n['value'];
    });
    return roomData;
}

function initUploadFile() {
    Dropzone.options.dropzoneCustom = {
        autoProcessQueue: false,
        url: '/hotel/api/upload-image',
        maxFiles: 1,
        maxfilesexceeded: function(file) {
            this.removeAllFiles();
            this.addFile(file);
        },
        init: function () {

            dropZoneUploadImage = this;

            this.on('success', function(file, xhr, formData) {
                let args = Array.prototype.slice.call(arguments);
                $("#image").val(args[1].fileName);
                $("#room-image").attr("src", args[1].fileName);
                $("#room-image").removeClass("hide");
                dropZoneUploadImage.removeAllFiles();
                addNewRoom();
            });

            this.on('addedfile', function(file, xhr, formData) {
                $("#room-image").addClass("hide");
            });
        }
    }

    $("#upload-image").on("click", function (argument) {
        $('.dropzone').get(0).click();
    });
}

function uploadImage(e) {
    e.preventDefault();
    if(dropZoneUploadImage.files.length)
        dropZoneUploadImage.processQueue();
    else
        addNewRoom();
    return false;
}
