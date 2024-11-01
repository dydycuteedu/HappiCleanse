/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.LoginGoogle.GooglePojo;
import utils.LoginGoogle.GoogleUtils;

@WebServlet(name = "LoginGoogleServlet", urlPatterns = {"/login-google"})
public class LoginGoogleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginGoogleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginGoogleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            Dao dao = new Dao();
            User googleUser = dao.checkAccountExistByUsernameAndEmail(googlePojo.getEmail());
            User user = new User();
            if (googleUser == null) {
                try {
                    user.setFullname(googlePojo.getGiven_name() + " " + googlePojo.getFamily_name());
                    user.setUsername(googlePojo.getEmail());
                    user.setPassword("HappiCleanse@2024");
                    user.setEmail(googlePojo.getEmail());
                    user.setAvatar(googlePojo.getPicture());
                    dao.singupbyEmail(user);
                    session.setAttribute("acc", user);
                    session.setMaxInactiveInterval(60 * 60 * 24);
                    //luu account len tren cookie
                    Cookie u = new Cookie("userC", user.getUsername());
                    Cookie p = new Cookie("passC", user.getPassword());
                    u.setMaxAge(60 * 60 * 24 * 365);//1 nam
                    response.addCookie(u);//luu u va p len Chrome
                    response.addCookie(p);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (googleUser != null) {
                session.setAttribute("acc", googleUser);
                session.setMaxInactiveInterval(60 * 60 * 24);
                //luu account len tren cookie
                Cookie u = new Cookie("userC", googleUser.getUsername());
                Cookie p = new Cookie("passC", googleUser.getPassword());
                u.setMaxAge(60 * 60 * 24 * 365);//1 nam
                response.addCookie(u);//luu u va p len Chrome
                response.addCookie(p);
            }
            request.getRequestDispatcher("/home").forward(request, response);
        }

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
