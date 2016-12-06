function buildTable() {

    $.getJSON('/api/contact/', {
        ajax: 'true'
    }, function(data) {
        console.log(data);
        var content = '';
        $.each(data, function(index, single) {
            content += "<tr id='contact"+ single.id +"'>" +
                "<td>" + single.id + "</td>" +
                "<td>" + single.firstName + " " + single.lastName + "</td>" +
                "<td>" + single.description + "</td>" +
                "<td>"  + single.address.street + ", "
                        + single.address.city + ", "
                        + single.address.state + ", "
                        + single.address.zip + "</td>" +
                "<td><button onclick='editContact(" + single.id + ")'>Edit</button></td>" +
                "<td><button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='"+ single.id +"'>Delete</button></td>" +
                "</tr>";

        });
        $('#contact-table').find('tbody').html(content);
    });
}

function insertContact() {
    //clear fields in modal
    $('#contactId').val("");
    $('#version').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#textAreaDescription').val("");
    $('#inputStreet').val("");
    $('#inputCity').val("");
    $('#inputState').val("");
    $('#inputZip').val("");
    //open modal
    $('#contactModal').modal('show');
}

function saveContact() {
    var id = $('#contactId').val();
    var version = $('#version').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var description = $('#textAreaDescription').val();
    var addressId = $('#addressId').val();
    var addressVersion = $('#addressVersion').val();
    var street = $('#inputStreet').val();
    var city = $('#inputCity').val();
    var state = $('#inputState').val();
    var zip = $('#inputZip').val();

    var contact = {
        id : id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        description: description,
        address: {
            id: addressId,
            version: addressVersion,
            street: street,
            city: city,
            state: state,
            zip: zip
        }
    }

    console.log(contact);

    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(contact),
        url: "/api/contact/",
        async: true,
        success: function() {
            buildTable();
            $('#contactModal').modal('hide');
            $('#successParagraph').html("Successfully saved " + firstName + " " + lastName + ".");
            $('#alertSuccess').modal('show');
        }
    })
}

function editContact(id) {
    // retrieve the contact with the passed in id
    $.getJSON('api/contact/' + id, {
        ajax: 'true'
    }, function(contact) {
        console.log(contact);
        // populate modal
        $('#contactId').val(contact.id);
        $('#version').val(contact.version);
        $('#inputFirstName').val(contact.firstName);
        $('#inputLastName').val(contact.lastName);
        $('#textAreaDescription').val(contact.description);
        $('#inputStreet').val(contact.address.street);
        $('#inputCity').val(contact.address.city);
        $('#inputState').val(contact.address.state);
        $('#inputZip').val(contact.address.zip);

        // open the modal
        $('#contactModal').modal('show');
    })
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        var modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/contact/" + id,
            async: true,
            dataType: "json",
            success: function () {
                buildTable();
                $('#confirmDeleteModal').modal('hide');
                $('#successParagraph').html("Successfully deleted contact ID#" + id + ".");
                $('#alertSuccess').modal('show');
            },
            error: function () {
                alert("Error Deleting Contact")
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}