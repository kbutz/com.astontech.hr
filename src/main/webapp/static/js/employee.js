function buildTable() {

    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function(data) {
        console.log(data)
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName;
            $('#employee-table').find('tbody')
                .append("<tr>" +
                "<td>" + single.id + "</td>" +
                "<td>" + single.firstName + " " + single.lastName + "</td>" +
                "<td>" + single.background + "</td>" +
                "<td>" +    "<select>" +
                "<option>(Select Project)</option>" +
                "</select></td>" +
                "<td>" + "<button onclick='editEmployee(" + single.id + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button onclick='deleteEmployee(" + single.id + ")'>Delete</button>" + "</td>" +
                "</tr>");

        });
    });
}

function saveEmployee() {
    var id = $('#employeeId').val();
    var version = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#textAreaBackground').val();

    var employee = {
        id : id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        project: []
    }

    console.log(employee);

    $.ajax({
        type: "post",
        data: employee,
        url: "/api/employee/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}