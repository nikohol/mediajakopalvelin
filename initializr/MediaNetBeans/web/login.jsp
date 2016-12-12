<%-- 
    Document   : login
    Created on : Dec 12, 2016, 4:57:36 PM
    Author     : Miikka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
	<title>Login</title>
	<link href="css/login.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">

	<script src="js/vendor/modernizr-2.8.3.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.1/fetch.min.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
        <main>
		<div class="user-login">
                    <h4 class="title"> LOGIN </h4>
                    <span id="msg">
                        <% if(request.getAttribute("warning") != null){ %>
                            <%= request.getAttribute("warning") %>
                        <% } %>
                    </span>
                    <form method="post" action="Login" id="user_login" accept-charset="UTF-8">
                        <label for="username">Username:</label>
			<input class="large" type="text" id="username" name="username" required>
			<label for="password">Password:</label>
			<input class="large" type="password" id="password" name="passowrd" required>
			<input class="sign-btn" type="submit" id="submit" name="submit" value="Login">
                    </form>
                    <div class="user-signup">
                        <h5 class="title"> Sign Up </h5>
                        <form method="post" action="Signup" id="user_login" accept-charset="UTF-8">
                            <label for="username">Username:</label>
                            <input class="large" type="text" id="username" name="username" required>
                            <label for="password">Password:</label>
                            <input class="large" type="password" id="password" name="passowrd" required>
                            <label for="password"> Confirm Password:</label>
                            <input class="large" type="password" id="password" name="passowrd" required>
                            <input class="sign-btn" type="submit" id="submit" name="submit" value="Sign Up">
                        </form>
                    </div>
		</div>
		<div class="user-register">
                    <h4 class="title">REGISTER</h4>
                    <a href="register.jsp" class="create-btn">CREATE ACCOUNT</a>
		</div>
	</main>
                    <footer>
		<div class="footer-inner">
			<div class="footer-col footer-left">
				<a class="logo" href="index.html"><img src="img/GSLogo.png" alt="GameShare"/></a>
			</div>
			<div class="footer-col footer-right">
				<ul class="extra">
					Maybe add something here later if need be!
				</ul>
			</div>
		</div>
		<p class="copyright"> No rights reserved :O </p>
	</footer>

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/plugins.js"></script>
        <script src="js/login.js"></script>

    </body>
</html>
