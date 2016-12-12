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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Miikka
 */

public class UploadDeails extends HttpServlet {

    // again we're just interested in the doPost!!!
    


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
        HttpSession hsession = request.getSession();
        
        String username = ((User)hsession.getAttribute("currentUser")).getUsername();
        Integer userID = ((User)hsession.getAttribute("currentUser")).getUid();
        Date currdate = new Date();
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String file = (String)hsession.getAttribute("file");
        String tag = request.getParameter("tags");

        try {
            //connecting to database
            String connectionURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "miikkatk", "seagh3id");
            
            PreparedStatement ps=connection.prepareStatement
                  ("INSERT INTO images VALUES(null,?,?,?,?,?,0,0,?,1,?,?)");
            ps.setString(1, title);
            ps.setString(2, date.format(currdate));
            ps.setString(3, location);
            ps.setInt(4, userID);
            ps.setString(5, "thumb/"+file);
            ps.setString(6, tag);
            
            int i=ps.executeUpdate();
            
            if(i>0){              
               RequestDispatcher view = request.getRequestDispatcher("UploadResult");
               view.forward(request, response);
            }             
        } catch (Exception e) {
            out.println("Error!" + e.getMessage());
        } finally {
            out.close();
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
