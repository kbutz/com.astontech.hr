<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h2>Employee Page</h2>
        <p>This application manages the Aston Tech employees.</p>
    </div>
    <script>
        $.getJSON('/api/employee/', {
            ajax: 'true'
        }, function(data) {
            console.log(data)
            $.each(data, function(index, single) {
                var fullName = single.firstName + " " + single.lastName;
                $('#employee-table').find('tbody')
                        .append($('<tr>'))
                        .append($('<td>').text(single.id))
                        .append($('<td>').text(fullName))
                        .append($('<td>').text(single.background))
                        .append($('<td>').text(single.projects));
            });
        });
    </script>
    <div class="container">
        <table id="employee-table" class="table table-striped table-hover">
           <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Background</th>
                    <th>Projects</th>
                </tr>
           </thead>
           <tbody>

                    <%--jquery will append data here--%>

           </tbody>
        </table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>