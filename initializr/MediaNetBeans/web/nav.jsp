<%-- 
    Document   : nav
    Created on : Dec 12, 2016, 5:31:16 PM
    Author     : Miikka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="javax.servlet.*,java.util.*, model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <% boolean connected = false;
        if(session.getAttribute("connected") != null) {
            String connect = (String) session.getAttribute("connected");
            connected = connect.equals("true");} %>
         <header>
            <!--
            topNav holds content for topmost navigation bar. In .css modify content with .topNav .left_logo .search .dropdown
            -->
            <nav class="topNav">
                <div class="left_logo">
                    <a href="index.html"><img src="img/GSLogo.png" alt="GameShare"/></a>
                </div>
                <div>
                    <form method="post" id="search-form">
                        <input class="search" type="text" name="search" placeholder="Search for content..." />
                    </form>
                    <%if (!connected) { %>
                    <a href="login.html">Login / Sign Up</a>
                    <%}%>
                    <%else if (connected) { %>
                    Hello! Enjoy your stay!
                    <div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Menu</button>
                        <div id="myDropdown" class="dropdown-content">
                            <a href="upload.html">Upload</a>
                            <a href="#">My profile</a>
                            <a href="#">Admin tools</a>
                        </div>
                    </div>
                    <%}%>
                </div>
                <!--
                <div>
                <!--
                JavaScript callout for top right Menu button
                
                    <div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">Menu</button>
                        <div id="myDropdown" class="dropdown-content">
                            <a href="upload.html">Upload</a>
                            <a href="#">My profile</a>
                            <a href="#">Admin tools</a>
                        </div>
                    </div>
                -->
            </nav>
            
        </header>
    </body>
</html>
