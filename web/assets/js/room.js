"use strict";
let dropZoneUploadImage = false;
$(document).ready(function () {
    getListRoom();
    $("#form-new-room").on("submit",uploadImage);
    initUploadFile();
    $("#tbl-list-room").on("click", ".btn-edit-room", editRoom);
    $("#tbl-list-room").on("click", ".btn-delete-room", openModalConfirmDeleteRoom);
    $("#btn-open-modal-new-form").on("click", resetForm);
    $("#btn-delete-room-confirm").on("click", deleteRoom);
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
    $.ajax("/hotel/api/room?roomId="+roomId,
        {
            type: "GET"
        }
    ).done(function (data) {
        let modalForm = $("#modal-new-room");
        modalForm.modal();
        modalForm.find(".modal-title").html("Edit Room:" + data.number)
        modalForm.find("#roomId").val(data.id);
        modalForm.find("#number").val(data.number);
        modalForm.find("#type").val(data.type);
        modalForm.find("#price").val(data.price);
        modalForm.find("#description").html(data.description);
        modalForm.find("#image").val(data.image);
        modalForm.find("#room-image").removeClass("hide").attr("src", data.image);

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
        $("#modal-new-room").modal("hide");
        formRoom.find(".modal-body").waitMe("hide");
        resetForm();
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

function resetForm() {
    let formRoom = $("#form-new-room");
    let submitButton = formRoom.find("button[type='submit']");
    document.getElementById("form-new-room").reset();
    submitButton.text("Submit");
    $("#room-image").removeClass("hide");
    $("#modal-new-room").find(".modal-title").html("New Room Form");
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

function openModalConfirmDeleteRoom() {
    $("#delete-conform-modal").modal();
    let roomId = $(this).data("room-id");
    $("#delete-conform-modal #btn-delete-room-confirm").data("roomId", roomId);
}

function deleteRoom() {
    $("#tbl-list-room tbody").waitMe();
    let roomId = $(this).data("room-id");
    $.ajax("/hotel/api/room?action=delete&roomId="+roomId,
        {
            "crossDomain": true,
            "method": "POST",
            "headers": {
                "Content-Type": "application/json",
                "cache-control": "no-cache"
            },
            "processData": false,
            "data": {},
            "dataType": "json"
        }
    ).done(function (data) {
        $("#tbl-list-room tbody").waitMe("hide");
        getListRoom();
    }).fail(function () {
        console.log("something went wrong!")
    }).always(function() {
        $("#tbl-list-room tbody").waitMe("hide");
        $("#tbl-list-room tbody").removeClass("emptyBody");
    });
}
