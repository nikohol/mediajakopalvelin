/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stuff;

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
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Miikka
 */
public class UserInformation extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

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
        String connection = (String)hsession.getAttribute("connection");
        boolean connected = connection.equals("true");
        if (connected) {
            String username = (String)hsession.getAttribute("login");
            User currUser = new User(); 
            try{
                //creating connection with the database 
                String connectionURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
                Connection connect = null;
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connect = DriverManager.getConnection(connectionURL, "miikkatk", "seagh3id");

                PreparedStatement statement =connect.prepareStatement("SELECT * FROM user WHERE Username=?");
                statement.setString(1, username);
                ResultSet result = statement.executeQuery();
                
                while (result.next()) {
                    currUser.setUid(result.getInt("Uid"));
                    currUser.setUsername(result.getString("Username"));
                    currUser.setAdmin(result.getBoolean("Admin"));
                }
                
                hsession.setAttribute("User", currUser);
                          
            }catch(Exception e) {
                e.printStackTrace();
            } 
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
