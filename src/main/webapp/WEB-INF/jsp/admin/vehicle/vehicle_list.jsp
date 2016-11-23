<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>
<script>
    $(document).ready(function() {
        $("#successAlert").delay(8000).fadeOut(2000);
        $("#errorAlert").delay(8000).fadeOut(2000);
    });
</script>
<div class="wrapper">
    <div class="col-sm-6" style="padding-left:45px;">
        <%--ALERTS--%>
        <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Success!</strong> Nothing broke and everything worked..
            </div>
        </div>
        <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
            <div class="alert alert-dismissible alert-warning">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4>Careful!</h4>
                <p>What are you playing at Potter?</p>
            </div>
        </div>
        <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
            <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Error!</strong> You broke the thing.
            </div>
        </div>
    </div> <!-- /ALERTS -->
    <div id="main-wrapper" class="col-sm-12">
        <div class="col-sm-12">
            <form:form cssClass="form-inline" modelAttribute="vehicleVO" id="formValidate" action="/admin/vehicle/add" method="post" autocomplete="on">
                <div class="form-group col-md-2">
                    <form:input type="text" class="form-control required" path="newVehicleMake" placeholder="Vehicle Make" required="required"/>
                </div>
                <div class="form-group col-md-2">
                    <form:input type="test" class="form-control" path="newVehicleModel" placeholder="Vehicle Model" required="required"/>
                </div>
                <div class="form-group col-md-2">
                    <form:input type="text" class="form-control" path="newLicensePlate" placeholder="License Plate" required="required"/>
                </div>
                <div class="form-group col-md-2">
                    <form:input type="text" class="form-control" path="newVIN" placeholder="VIN" required="required"/>
                </div>
                <div class="form-group col-md-2">
                    <form:input type="number" class="form-control" path="newVehicleYear" placeholder="Year" required="required"/>
                </div>
                <div class="form-group col-md-1">
                    <form:input type="text" class="form-control" path="newColor" placeholder="Color" required="required"/>
                </div>
                <div class="col-sm-12" style="margin-top:5px;">
                    <button type="submit" class="btn btn-primary btn-block">Add New Vehicle</button>
                </div>
            </form:form>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Make</th>
                        <th>Model</th>
                        <th>License Plate</th>
                        <th>VIN</th>
                        <th>Year</th>
                        <th>Color</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.VIN}</td>
                        <td>${vehicle.vehicleYear}</td>
                        <td>${vehicle.color}</td>
                        <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div> <!-- end main wrapper -->

</div>

<%@include file="../../includes/footer.jsp" %>