<div class="modal fade" id="new-booking-modal" tabindex="-1" role="dialog" aria-labelledby="addBook" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <form id="new-booking">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="modal-title h2">New Booking Form</span>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="checkIn" class="col-form-label col-sm-2">*Check in</label>
                        <div class="col-sm-4">
                            <input required type="date" placeholder="MM/DD/YYYY" class="form-control" name="checkIn"
                                   id="checkIn"/>
                        </div>

                        <label for="checkOut" class="col-form-label col-sm-2">*Check out</label>
                        <div class="col-sm-4">
                            <input required type="date" placeholder="MM/DD/YYYY" class="form-control" name="checkOut"
                                   id="checkOut"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="guestID" class="col-form-label col-sm-2">*Guest</label>
                        <div class="col-sm-2">
                            <input required type="text" class="form-control" name="guestID" id="guestID"/>
                        </div>
                        <div id="generateGuestInfo" class="col-sm-4"></div>
                        <div class="dropdown search-guest col-sm-4">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button" data-toggle="dropdown">Search Guest<span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <input class="form-control" id="searchGuest" type="text" placeholder="Search.."/>
                                <%-- contented redered in javascript --%>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomNumber" class="col-form-label col-sm-2">*Room</label>
                        <div class="col-sm-6">
                            <input required type="text" class="form-control" name="roomNumber" id="roomNumber" readonly>
                        </div>
                        <div class="dropdown find-room col-sm-4">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button" data-toggle="dropdown">Find Room<span class="caret"></span></button>
                            <ul class="dropdown-menu">
                            <%-- contented redered in javascript --%>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="numberOfNight" class="col-sm-2 col-form-label">Number of Night</label>
                        <div class="col-sm-2">
                            <input type="number" class="form-control" id="numberOfNight" name="numberOfNight" placeholder="0" readonly>
                        </div>

                        <label for="roomPrice" class="col-sm-2 col-form-label">Room Price</label>
                        <div class="col-sm-2">
                            <input type="number" class="form-control" id="roomPrice" name="roomPrice" placeholder="100.00" readonly>
                        </div>

                        <label for="totalPrice" class="col-sm-2 col-form-label">Total Price</label>
                        <div class="col-sm-2">
                            <input type="number" class="form-control" id="totalPrice" name="totalPrice" placeholder="100.00" readonly>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <div class="progress hide">
                            <div class="progress-bar progress-bar-striped progress-bar-animated active"
                                 role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
                                 style="width: 100%">
                            </div>
                        </div>
                        <button type="reset" class="btn btn-outline-danger" data-dismiss="modal">Reset
                        </button>
                        <button type="submit" class="btn btn-outline-primary">Save</button>
                        <button type="button" class="btn btn-outline-danger"
                                aria-label="Close" aria-hidden="true" data-dismiss="modal">Close
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>