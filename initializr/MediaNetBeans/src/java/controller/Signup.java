/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {
    EntityManagerFactory emf;
    EntityManager em;
      
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
                emf = Persistence.createEntityManagerFactory("MediaNetBeansPU");
                em = emf.createEntityManager();
                          
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String cpassword = request.getParameter("cpassword");
                //by default new signups arent given administrator rights.
                
                if(password.equals(cpassword)){                   
                em.getTransaction().begin();
                
                User user = new User();
                user.setUsername(username);
                user.setPword(password);
                user.setAdmin(false);
                
                em.persist(user);
               
                em.getTransaction().commit();
                
                out.println("Signed up: " + username);
                }
            } catch (Exception e) {
                out.println("Uh-oh : " + e);
            } finally {
                em.close();
                emf.close();
            }
    }
    }
}