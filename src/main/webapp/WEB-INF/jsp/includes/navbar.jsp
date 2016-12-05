<nav class="navbar navbar-static-top navbar-inverse" style="margin-bottom:0px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <%--HOME--%>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--PAGE LINKS--%>
                <li><a href="/employee">Employee</a></li>
                <li><a href="/project">Project</a></li>
                <li><a href="/addressbook">Address Book</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/admin">Admin</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--LOGIN LINKS--%>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal.username" var="username" />
                    <li><a href="/logout">Logout  <strong>${username}</strong></a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login">Login</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>