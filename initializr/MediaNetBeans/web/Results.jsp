<%-- 
    Document   : Results
    Created on : Dec 12, 2016, 7:06:57 PM
    Author     : Miikka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp</title>
    </head>
    <body>
        <h1>
            <% String result = (String) request.getAttribute("result"); %>
            <%= result %>
        </h1>
        <a href="index.html">Home!</a>
    </body>
</html>
