/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Email;
import model.EmailUtils;
import model.User;

/**
 *
 * @author CHUC DY
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "management":
                    Management(request, response);
                    break;
                case "approve":
                    Approve(request, response);
                    break;
                case "deny":
                    Deny(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "management":
                    Management(request, response);
                    break;
                case "approve":
                    Approve(request, response);
                    break;
                case "deny":
                    Deny(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void Management(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();
        ArrayList<User> allUsers = dao.getAllUsers();
        ArrayList<User> customerList = new ArrayList<>();
        for (User user : allUsers) {
            if ("Staff".equals(user.getRole()) && user.getIsCheck() == 0 && user.getIsValid()==1) {
                customerList.add(user);
            }
        }

        request.setAttribute("list", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/registerstaff/index.jsp");
        dispatcher.forward(request, response);
    }

    private void Approve(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        User user = dao.getUser(id);
        user.setIsCheck(1);
        dao.approveStaff(user);
        Email email = new Email();
        email.setFrom("trantrucvy265@gmail.com");
        email.setFromPassword("igww uwrd ytua jmja");
        email.setTo(user.getEmail());
        email.setSubject("Congratulations!!!");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(user.getFullname()).append("<br>");
        sb.append("You have just been Approved to be a staff at HappiCleanse. <br> ");
        sb.append("Login in our system with your username is ").append(user.getUsername()).append(" and your password is 111<br>");
        sb.append("Remember to change your password when you login. <br> ");
        sb.append("Regards<br>");
        sb.append("Administrator");
        email.setContent(sb.toString());
        EmailUtils.send(email);
        Management(request, response);
    }

    private void Deny(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        User user = dao.getUser(id);
        user.setIsValid(0);
        dao.denyStaff(user);
        Email email = new Email();
        email.setFrom("trantrucvy265@gmail.com");
        email.setFromPassword("igww uwrd ytua jmja");
        email.setTo(user.getEmail());
        email.setSubject("Unfortunately!!!");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(user.getFullname()).append("<br>");
        sb.append("You have just been Rejected to be a staff at HappiCleanse. <br> ");
        sb.append("See you again. <br> ");
        sb.append("Regards<br>");
        sb.append("Administrator");
        email.setContent(sb.toString());
        EmailUtils.send(email);
        Management(request, response);
    }
}
