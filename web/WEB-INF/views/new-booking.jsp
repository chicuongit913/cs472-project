<div class="modal fade" id="add-book" tabindex="-1" role="dialog" aria-labelledby="addBook" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <form id="new-booking" method="post" action="/new-booking">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">New Booking Form</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title" class="col-form-label">*Room</label>
                        <input required type="text" class="form-control" name="title" id="title">
                    </div>
                    <div class="form-row" >
                        <div class="form-group col-6">
                            <label for="isbn" class="col-form-label">ISBN</label>
                            <input required class="form-control" name="isbn" id="isbn"/>
                        </div>
                        <div class="form-group col-6">
                            <label for="overdueFee" class="col-form-label">Overdue Fee per day</label>
                            <input required placeholder="0.00" class="form-control" name="overdueFee" id="overdueFee"/>
                            <small class="text-muted">Enter valid decimal amount; in dollars and cents; no comma (eg 1.99)</small>
                        </div>
                    </div>

                    <div class="form-row" >
                        <div class="form-group col-6">
                            <label for="publisher" class="col-form-label">Publisher</label>
                            <input required class="form-control" name="publisher" id="publisher"/>
                        </div>
                        <div class="form-group col-6">
                            <label for="datePublished" class="col-form-label">Overdue Fee per day</label>
                            <input required placeholder="mm/dd/yyyy" class="form-control" type="date" name="datePublished" id="datePublished"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-outline-danger" data-dismiss="modal">Reset</button>
                    <button type="submit" class="btn btn-outline-primary">Save book</button>
                </div>
            </div>
        </form>
    </div>
</div>