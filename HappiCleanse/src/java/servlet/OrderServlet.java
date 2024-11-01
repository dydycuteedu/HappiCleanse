/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DetailShifts;
import model.Order;
import model.Shifts;
import model.User;

/**
 *
 * @author CHUC DY
 */
public class OrderServlet extends HttpServlet {

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
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
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
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void View(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            Dao dao = new Dao();
            int id = Integer.parseInt(request.getParameter("id"));
            Order o = dao.getOrder(id);
            request.setAttribute("o", o);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/order/detail.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            Dao dao = new Dao();
            int id = Integer.parseInt(request.getParameter("id"));
            Order o = dao.getOrder(id);
            //DetailShifts detailshift = dao.getDetailShift(shift.getIdShift());
            ArrayList<User> allUsers = dao.getAllUsers();

            // Filter users with role 'customer'
            ArrayList<User> allStaff = new ArrayList<>();
            for (User user : allUsers) {
                if ("Staff".equals(user.getRole()) && user.getIsCheck() == 1) {
                    allStaff.add(user);
                }
            }
            List<User> staffavailable = new ArrayList<>();
            for (User u : allStaff) {
                List<Order> orderlist = dao.getOrderinprogressbystaffID(u.getIdUser());
                if (!orderlist.isEmpty()) {
                    for (Order oder : orderlist) {
                        if (!o.getTimeStart().equals(oder.getTimeStart())) {
                            staffavailable.add(u);
                        }
                    }
                } else {
                    staffavailable.add(u);
                }
            }
            request.setAttribute("o", o);
            request.setAttribute("staff", staffavailable);
            //request.setAttribute("detailshift", detailshift);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/order/edit.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//

    private void Delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("id"));
            Dao dao = new Dao();
            Order order = dao.getOrder(idOrder);
            order.setStatusOrder("Cancelled");
            dao.cancelOrder(order);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminServlet");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Save(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        int staff = Integer.parseInt(request.getParameter("staff"));
        Dao dao = new Dao();
        Order o = dao.getOrder(id);
        o.setStaff(dao.getUser(staff));
        o.setStatusOrder("In Progress");
        dao.updateStaffOrder(o);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminServlet");
        dispatcher.forward(request, response);
    }
}
