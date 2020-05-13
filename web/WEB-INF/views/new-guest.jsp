<div class="modal fade" id="add-guest" tabindex="-1" role="dialog" aria-labelledby="addGuest" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <form id="new-guest">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="modal-title h2">New Guest Form</span>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">X</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="firstName" class="col-form-label col-sm-2">*First Name</label>
                        <div class="col-sm-4">
                            <input required type="text" class="form-control" name="firstName" id="firstName"/>
                        </div>
                        <label for="lastName" class="col-form-label col-sm-2">*Last Name</label>
                        <div class="col-sm-4">
                            <input required type="text" class="form-control" name="lastName" id="lastName"/>
                        </div>
                        <label for="address" class="col-form-label col-sm-2">Address</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="address" id="address"/>
                        </div>
                        <label for="email" class="col-form-label col-sm-2">Email</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" id="email"/>
                        </div>
                        <label for="phoneNumber" class="col-form-label col-sm-2">Phone Number</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"/>
                        </div>
                        <label for="dob" class="col-form-label col-sm-2">Date Of Birth</label>
                        <div class="col-sm-4">
                            <input type="date" placeholder="MM/DD/YYYY" class="form-control" name="dob" id="dob"/>
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
                        <button type="button" class="btn btn-outline-danger" aria-label="Close" aria-hidden="true" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>