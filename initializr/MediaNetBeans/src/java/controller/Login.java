/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Stuff.Validation;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 *
 * @author Miikka
 */
public class Login extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String user = request.getParameter("username");
        String password = request.getParameter("pword");
        
        if(Validation.uValidate(user, password)){
            // Gets serssion and sets attributes
            HttpSession hsession = request.getSession();
            hsession.setAttribute("connection:","true");
            hsession.setAttribute("login:", user);
            //creates current user
            User currUser = new User();
            
            RequestDispatcher getUser = request.getRequestDispatcher("GetUser.do");
            getUser.include(request,response);
        }
        else{
            String error = "The username/password combination is invalid.";
            request.setAttribute("login failed:", error);
            RequestDispatcher reqdp = request.getRequestDispatcher("login");
            reqdp.forward(request, response);
        }
}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
