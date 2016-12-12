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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miikka
 */

public class Check extends HttpServlet {
    // only interested in doPost



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
        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            //establishing connection to database
            String connectionURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "miikkatk", "seagh3id");
            
            String uname = request.getParameter("username");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE Username=?"); 
            statement.setString(1,uname);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                out.println("not taken");
            } else {
                out.println("taken");
            }
        } catch (Exception e) {
            out.println("Error!" + e);
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
