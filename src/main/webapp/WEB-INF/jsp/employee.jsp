<%--suppress XmlPathReference --%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/employee.js" var="employee" />
<script src="${employee}"></script>
<script>
    $(document).ready(function () {
        buildTable();
    })
</script>

<div class="container">
    <div class="jumbotron">
        <h2>Employee Page</h2>
        <p>This application manages the Aston Tech employees.</p>
    </div>
    <button onClick="$('#employeeModal').modal('show')" class="btn btn-default">Add New Employee</button>
    <div class="container">
        <table id="employee-table" class="table table-striped table-hover">
           <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Background</th>
                    <th>Projects</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
           </thead>
           <tbody>

                    <%--jquery will append data here--%>

           </tbody>
        </table>
        <div class="modal" id="employeeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Employee Details</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <fieldset>

                                <div class="form-group">
                                    <label for="inputFirstName" class="col-lg-2 control-label">First Name</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputFirstName" placeholder="Email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputLastName" class="col-lg-2 control-label">First Name</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputLastName" placeholder="Email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="textAreaBackground" class="col-lg-2 control-label">Textarea</label>
                                    <div class="col-lg-10">
                                        <textarea class="form-control" rows="3" id="textAreaBackground"></textarea>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>