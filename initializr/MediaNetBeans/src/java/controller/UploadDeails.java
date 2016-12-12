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
import model.Content;

/**
 *
 * @author Miikka
 */
//OOOPS typo, meant to be Details :|
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
        //gets input from the html form
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String file = (String)hsession.getAttribute("file");
        String tag = request.getParameter("tags");

        try {
            //connecting to database
            String cURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
            Connection connect = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(cURL, "miikkatk", "seagh3id");
            //Inserting information about the upload to the Content table
            PreparedStatement statement=connect.prepareStatement("INSERT INTO Content VALUES(null,?,?,?,?,?,0)");
            statement.setInt(1, userID);
            statement.setString(2, title);
            statement.setString(3, location);
            statement.setString(4, date.format(currdate));          
            //statement.setString(6, "thumb/"+file);
            
            int i=statement.executeUpdate();
            if(i>0){              
               RequestDispatcher view = request.getRequestDispatcher("UploadResult");
               view.forward(request, response);
            }
            PreparedStatement getContentid = connect.prepareStatement("SELECT cid FROM Content WHERE title = "+title);
            int cid = getContentid.executeUpdate();
            PreparedStatement statement2 = connect.prepareStatement("INSERT INTO Tags VALUES(null,?,?)");
            statement2.setInt(1, cid);
            statement2.setString(2, tag);
            int j=statement2.executeUpdate();
            if(j>0){
                RequestDispatcher view2 = request.getRequestDispatcher("UploadResult");
                view2.forward(request, response);
            }
        } catch (Exception e) {
            out.println("Error!" + e);
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
