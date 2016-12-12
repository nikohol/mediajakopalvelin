/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Miikka
 */

public class Signup extends HttpServlet {

//the beginning part of each of these servlets is useless... we're only interested in the doPost

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        User u = new User();
        
        String username = request.getParameter("username");
        String pword = request.getParameter("password");
        String confpword = request.getParameter("confirm");
        
        if(pword.equals(confpword)){
                
        try {
 
            String connectionURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "miikkatk", "seagh3id");
            
            PreparedStatement ps=connection.prepareStatement("INSERT INTO users VALUES(null,null,null)");
            ps.setString(1, username);
            ps.setString(2, pword);
            ps.setString(7, "USER_ROLE"); 
            
            int i=ps.executeUpdate();
            if(i>0){
               RequestDispatcher view = request.getRequestDispatcher("Logging");
                view.forward(request, response);
            }             
        } catch (Exception e) {
            out.println("Error!" + e);
        } finally {
            out.close();
        }
        }
        else{
            System.out.println("Password and Confirm Password does not match!!");   
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
    }// </editor-fold>

}
