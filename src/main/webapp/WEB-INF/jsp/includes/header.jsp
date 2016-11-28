<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <%--FAVICON--%>
        <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
            <script src="${jquery}"></script>

        <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.min.js" var="bootstrap" />
            <script src="${bootstrap}"></script>

        <c:url value="/static/css/bootstrap.min.css" var="bootstrapCSS" />
            <link href="${bootstrapCSS}" rel="stylesheet" media="screen" />

        <c:url value="/static/js/common.js" var="common" />
            <script src="${common}"></script>

        <c:url value="/static/css/astonengineer.css" var="bootstrapcustom" />
            <link href="${bootstrapcustom}" rel="stylesheet" media="screen" />

        <title>Aston Technologies HR Application</title>


    </head>
    <body>