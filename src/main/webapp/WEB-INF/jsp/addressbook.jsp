<%--suppress XmlPathReference --%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/addressbook.js" var="contact" />
<script src="${contact}"></script>
<script>
    $(document).ready(function () {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">

    <h2>Address Book</h2>
    <p>This application maintains a list of Contact's and their associated address.</p>

    <button onClick="insertContact()" class="btn btn-default">Add New Contact</button>

    <div class="container">
        <table id="contact-table" class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>

            <%--jquery will append data here--%>

            </tbody>
        </table>
    </div>
    <div class="modal fade" id="contactModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Contact Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>

                            <hidden id="contactId" />
                            <hidden id="version" />
                            <hidden id="addressId" />
                            <hidden id="addressVersion" />

                            <div class="form-group">
                                <label for="inputFirstName" class="col-lg-2 control-label">First Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputFirstName" placeholder="Email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputLastName" class="col-lg-2 control-label">Last Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputLastName" placeholder="Email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="textAreaDescription" class="col-lg-2 control-label">Description</label>
                                <div class="col-lg-10">
                                    <textarea class="form-control" rows="3" id="textAreaDescription"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputStreet" class="col-lg-2 control-label">Street</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputStreet" placeholder="Street">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputCity" class="col-lg-2 control-label">City</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputCity" placeholder="City">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputState" class="col-lg-2 control-label">State</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputState" placeholder="State">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputZip" class="col-lg-2 control-label">Zip Code</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputZip" placeholder="Zip Code">
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContact()">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="confirmDeleteModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirm Delete</h4>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete? This cannot be undone!</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">
                        Delete</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="alertSuccess">
        <div class="modal-dialog">
            <div class="alert alert-success">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <p id="successParagraph"></p>
            </div>
        </div>
    </div>

</div>

<%@ include file="includes/footer.jsp" %>