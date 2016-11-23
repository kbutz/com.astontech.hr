<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%-- SIDEBAR --%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <c:set var="idx" value="0" scope="page" />
            <form:form class="form-horizontal" modelAttribute="vehicleAttribute" action="/admin/vehicle/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleMake" class="col-sm-3 control-label">Vehicle Make: </label>
                        <div class="col-sm-9">
                            <form:input path="vehicleModel.vehicleMake.vehicleMakeName" type="text" id="inputVehicleMake" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleModel" class="col-sm-3 control-label">Vehicle Model: </label>
                        <div class="col-sm-9">
                            <form:input path="vehicleModel.vehicleModelName" type="text" id="inputVehicleModel" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="inputLicensePlate" class="col-sm-3 control-label">License Plate: </label>
                        <div class="col-sm-9">
                            <form:input path="licensePlate" type="text" id="inputLicensePlate" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="inputVIN" class="col-sm-3 control-label">VIN: </label>
                        <div class="col-sm-9">
                            <form:input path="VIN" type="text" id="inputVIN" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleYear" class="col-sm-3 control-label">Year: </label>
                        <div class="col-sm-9">
                            <form:input path="vehicleYear" type="text" id="inputVehicleYear" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="inputColor" class="col-sm-3 control-label">Color: </label>
                        <div class="col-sm-9">
                            <form:input path="color" type="text" id="inputColor" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div class="col-sm-9 col-sm-offset-3">
                            <button class="btn btn-primary btn-block" name="update">Update Vehicle Record</button>
                        </div>
                    </div>
                </div>
            </form:form>

        </div>
        <div class="col-sm-4">
            <%--ALERTS--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="../../includes/footer.jsp" %>