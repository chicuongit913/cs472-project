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

                    <div class="form-row">
                        <div class="form-group">
                            <div class="dropdown">
                                <label for="status">Status</label>
                                <select class="form-control" id="status" name="status">
                                    <option value="AVAILABLE">AVAILABLE</option>
                                    <option value="PENDING">PENDING</option>
                                    <option value="CONFIRMED">CONFIRMED</option>
                                    <option value="COMPLETED">COMPLETED</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-row" >
                        <div class="form-group">
                            <label for="roomNumber" class="col-form-label">*Room</label>
                            <input required type="text" class="form-control" name="roomNumber" id="roomNumber">
                        </div>
                        <div class="form-group">
                            <label for="guestID" class="col-form-label">*Guest</label>
                            <input required type="text" class="form-control" name="guestID" id="guestID"/>
                        </div>
                    </div>

                    <div class="form-row" >
                        <div class="form-group">
                            <label for="checkIn" class="col-form-label">*Check in</label>
                            <input required type="date" placeholder="MM/DD/YYYY" class="form-control" name="checkIn" id="checkIn"/>
                        </div>
                        <div class="form-group">
                            <label for="checkOut" class="col-form-label">*Check out</label>
                            <input required type="date" placeholder="MM/DD/YYYY" class="form-control" name="checkOut" id="checkOut"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <div class="progress hide">
                        <div class="progress-bar progress-bar-striped progress-bar-animated active"
                             role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
                             style="width: 100%"></div>
                    </div>
                    <button type="reset" class="btn btn-outline-danger" data-dismiss="modal">Reset</button>
                    <button type="submit" class="btn btn-outline-primary">Save</button>

                </div>
            </div>
        </form>
    </div>
</div>