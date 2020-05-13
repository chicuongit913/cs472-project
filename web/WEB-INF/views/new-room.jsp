<div class="modal fade" id="modal-new-room" tabindex="-1" role="dialog" aria-labelledby="addRoom" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <form id="form-new-room">
            <div class="modal-content">
                <div class="modal-header">
                    <span class="modal-title h2">New Room Form</span>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-row" >
                        <input type="text" class="form-control" name="id" id="roomId">
                        <div class="form-group">
                            <label for="number" class="col-form-label">*Room No.</label>
                            <input required type="text" class="form-control" name="number" id="number">
                        </div>
                        <div class="form-group">
                            <div class="dropdown">
                                <label for="type">*Room Type</label>
                                <select class="form-control" id="type" name="type">
                                    <option value="">Please Select Room Type</option>
                                    <option value="Single Room">Single Room</option>
                                    <option value="Double Room">Double Room</option>
                                    <option value="Triple Room">Triple Room</option>
                                    <option value="Quad Room">Quad Room</option>
                                    <option value="Queen Room">Queen Room</option>
                                    <option value="King Room">King Room</option>
                                    <option value="Twin Room">Twin Room</option>
                                    <option value="Hollywood Twin Room">Hollywood Twin Room</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="col-form-label">*Room Price</label>
                            <input required type="text" class="form-control" name="price" id="price">
                        </div>

                        <div class="form-group">
                            <label for="description" class="col-form-label">*Room Description</label>
                            <textarea required type="text" class="form-control" name="description" id="description"></textarea>
                        </div>

                        <div id="block-room-image-upload" class="form-group">
                            <label for="description" class="col-form-label">Image</label>

                            <input type="text" class="form-control" name="image" id="image"/>
                            <img id="room-image" class="hide" src="">
                            <div class="dropzone" id="dropzone-custom" ></div>
                            <button type="button" id="upload-image" class="btn btn-info">Choose file</button>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn" data-dismiss="modal">Reset</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal fade" id="delete-conform-modal" tabindex="-1" role="dialog" aria-labelledby="deleteRoom" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-primary" id="btn-delete-room-confirm">Delete</button>
                <button type="button" data-dismiss="modal" class="btn">Cancel</button>
            </div>
        </div>
    </div>
</div>