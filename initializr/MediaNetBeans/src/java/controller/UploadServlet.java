/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Miikka
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
//defines the allowed file and request sizes (5MB)
@MultipartConfig(location = "/home/glassfish/glassfish4/glassfish/domains/domain1/applications/upload/thumb",//or whatever our server will be
        fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5)

public class UploadServlet extends HttpServlet {




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
        
        final Part file = request.getPart("...");
        final String fileName = getFile(file);
        file.write(fileName);
        HttpSession hsession = request.getSession();
        hsession.setAttribute("Name of File:", fileName);
        request.getRequestDispatcher("imageForm").forward(request, response);
        
        
    }
    private static String getFile(Part part) {
        for (String c : part.getHeader("content-disposition").split(";")) {
            
            if (c.trim().startsWith("filename")) {
                return c.substring(c.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
    return null;
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
