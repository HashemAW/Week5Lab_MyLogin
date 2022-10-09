/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

/**
 *
 * @author Hashem
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User realuser = (User) session.getAttribute("realuser");
         String logout = request.getParameter("logout");
        
        
        if(logout !=null){   
            session.invalidate();
            request.setAttribute("message", "You have sucessfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            
        }
        else{
             if(realuser != null)
            {   
                response.sendRedirect("home");
                 return;
                
            }
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userN = request.getParameter("username");
        String passW = request.getParameter("password");
        
        User user = new User(userN, passW);
        HttpSession session = request.getSession();
        
        AccountService as = new AccountService();
        
        if(as.login(userN, passW)== null){
          request.setAttribute("message", "Error: Authentication Failed"); 
          request.setAttribute("username", user);
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          return;
        }
          else{
             request.setAttribute("message", "Message: Authentication Successfull"); 
            session.setAttribute("username", user);
            response.sendRedirect("home");
            return;
        }
    }
}