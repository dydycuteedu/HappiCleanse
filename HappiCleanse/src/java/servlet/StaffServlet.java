/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author CHUC DY
 */
public class StaffServlet extends HttpServlet {

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
            out.println("<title>Servlet StaffServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffServlet at " + request.getContextPath() + "</h1>");
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
                case "view":
                    View(request, response);
                    break;
                case "edit":
                    Edit(request, response);
                    break;
                case "delete":
                    Delete(request, response);
                    break;
                case "Save":
                    Save(request, response);
                    break;
                case "Add":
                    Add(request, response);
                    break;
                case "create":
                    Create(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                case "view":
                    View(request, response);
                    break;
                case "edit":
                    Edit(request, response);
                    break;
                case "delete":
                    Delete(request, response);
                    break;
                case "Save":
                    Save(request, response);
                    break;
                case "Add":
                    Add(request, response);
                    break;
                case "create":
                    Create(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void Management(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Dao dao = new Dao();
        ArrayList<User> allUsers = dao.getAllUsers();

        // Filter users with role 'customer'
        ArrayList<User> customerList = new ArrayList<>();
        for (User user : allUsers) {
            if ("Staff".equals(user.getRole())) {
                customerList.add(user);
            }
        }

        request.setAttribute("list", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/staff/index.jsp");
        dispatcher.forward(request, response);
    }

    private void Create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/staff/create.jsp");
        dispatcher.forward(request, response);
    }
//

    private void View(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Dao dao = new Dao();
        int uid = Integer.parseInt(request.getParameter("id"));

        User user = dao.getUser(uid);

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/staff/detail.jsp");
        dispatcher.forward(request, response);
    }
//
//  
private void Delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int rid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        dao.deleteStaff(rid);
        Management(request, response);
    }
    private void Edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int uid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        User user = dao.getUser(uid);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/staff/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void Add(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ufullname = request.getParameter("fullname");
        String uname = request.getParameter("username");
        String upass = request.getParameter("password");
        String uemail = request.getParameter("email");
        String uphone = request.getParameter("phonenumber");
        String ugender = request.getParameter("gender");
        String uaddress = request.getParameter("address");
        String uavatar = request.getParameter("avatar");
        String urole = request.getParameter("role");
        Dao dao = new Dao();
        try {
            dao.singupStaff(ufullname, uname, upass, uemail, uphone, uaddress, ugender, uavatar);
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Management(request, response);
    }
//save for edit
    private void Save(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int uid = Integer.parseInt(request.getParameter("id"));
        String uname = request.getParameter("name");
        boolean status = request.getParameter("status") != null;
        int isValid = 0;
        if (status) {
            isValid = 1;
        }
        Dao dao = new Dao();
        User user = dao.getUser(uid);
        user.setUsername(uname);
        user.setIsValid(isValid);
        dao.editProfile(user);
        Management(request, response);
    }
}
