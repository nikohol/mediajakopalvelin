/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import model.User;
import model.Content;
import model.ContentTags;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Miikka
 */
@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
@MultipartConfig(location = "/img/content",
        fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5)
public class Upload extends HttpServlet {
    
    EntityManagerFactory emf;
    EntityManager em;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final String path = "/img/content/";
        final Part filePart = request.getPart("file");
        final int userId = Integer.parseInt(request.getParameter("user"));
        String title = request.getParameter("title");
        String tag = request.getParameter("tag");
        
        
        
        
        final String fileName = getFileName(filePart);
        final String currentTime = System.currentTimeMillis() + "_";

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            
            out = new FileOutputStream(new File(path + File.separator
                    + currentTime + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            emf = Persistence.createEntityManagerFactory("MediaNetBeansPU");
            em = emf.createEntityManager();

            Query q = em.createQuery("SELECT u FROM User u");
            List<User> userList = q.getResultList();
            User uploadUser = new User();
            for (User user : userList) {
                    if(user.getUid().equals(userId)){
                         uploadUser = user;
                    }
            }
            
            em.getTransaction().begin();

            Content content = new Content();
            Date date = new Date();
            

            content.setDop(date);
            content.setLocation(fileName);
            content.setUid(uploadUser);
            content.setTitle(title);
          
            em.persist(content);
            em.getTransaction().commit();
            
            //its 6:21 am, can't figure it out....... so nothing works
            
            /*Query que = em.createQuery("SELECT c FROM Content c");
            List<Content> contentList = que.getResultList();
            Content find = new Content();
            int gotcha = 0;
            for (Content c : contentList) {
                    if(find.getDop().equals(date)){
                          gotcha = c.getCid();
                          
                    }
            }
            ContentTags tags = new ContentTags();
            
            tags.setTag(tag);
            tags.setCid(gotcha);*/
            

            writer.println("File "+ fileName + " uploaded");

        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        } finally {
            em.close();
            emf.close();
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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