<%-- 
    Document   : index.jsp
    Created on : Dec 12, 2016, 4:53:52 PM
    Author     : Miikka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*,java.util.*, model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GameShare</title>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/2.0.1/fetch.min.js"></script>
    </head>
    <body>
        <jsp:include page="nav.jsp" />
        
        <nav class="left-nav">
                <ul>
                <li>
                    <a href="#">&#9776;</a>
                 </li>
                <li>
                    <a href="index.html">Most Recent</a>                        
                </li>
                <li>
                    <a href="index.html">Popular</a>
                 </li>
                <li>
                    <a href="index.html">Friends</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <section class="image-container">
		<ul id="image-grid">

           <!-- <div class="content grey">
                
                <section>
                    <article class="title">
                        <h2>Most Recent</h2>
                    </article>
                    
                    <ul class="container">
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="http://placekitten.com/400/361">
                                <figcaption>
                                    <h3>Title</h3>
                                </figcaption>
                            </figure>
                        </li>
                        

                    </ul>
                </section>    
            </div>
           -->
                </ul>
            </section>
        </main>
         <footer>
            <div class="footer-inner">
                <div class="footer-col footer-left">
                    <a class="logo" href="index.html"><img src="img/GSLogo.png" alt="GameShare"/></a>
                    <!-- <div class="description">
                        <p> A land for creatives sharing their works, projects, and process. Looking for an inspiration? You're on the right track.</p>
                    </div> -->
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
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')
        
        </script>

        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
