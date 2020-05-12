<div class="modal fade" id="add-book" tabindex="-1" role="dialog" aria-labelledby="addBook" aria-hidden="true">
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
                        <div class="col-sm-6">
                            <input required type="text" class="form-control" name="guestID" id="guestID"/>
                        </div>
                        <div class="dropdown search-guest col-sm-4">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button" data-toggle="dropdown">Search Guest<span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <input class="form-control" id="searchGuest" type="text" placeholder="Search.."/>
                                <li><a href="#">G001</a></li>
                                <li><a href="#">V002</a></li>
                                <li><a href="#">G002</a></li>
                                <li><a href="#">V002</a></li>
                                <li><a href="#">G102</a></li>
                                <li><a href="#">V111</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomNumber" class="col-form-label col-sm-2">*Room</label>
                        <div class="col-sm-6">
                            <input required type="text" class="form-control" name="roomNumber" id="roomNumber">
                        </div>
                        <div class="dropdown find-room col-sm-4">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button" data-toggle="dropdown">Find Room<span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <input class="form-control" id="findRoom" type="text" placeholder="Search.."/>
                                <li><a href="#">1001</a></li>
                                <li><a href="#">2001</a></li>
                                <li><a href="#">3002</a></li>
                                <li><a href="#">4001</a></li>
                                <li><a href="#">5002</a></li>
                                <li><a href="#">1002</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="status" class="col-sm-2 col-form-label">Status</label>
                        <div class="col-sm-4">
                            <div class="dropdown">
                                <select class="form-control" id="status" name="status">
                                    <option value="AVAILABLE">AVAILABLE</option>
                                    <option value="PENDING">PENDING</option>
                                    <option value="CONFIRMED">CONFIRMED</option>
                                    <option value="COMPLETED">COMPLETED</option>
                                </select>
                            </div>
                        </div>

                        <label for="roomPrice" class="col-sm-2 col-form-label">Room Price</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="roomPrice" name="roomPrice" placeholder="100.00">
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