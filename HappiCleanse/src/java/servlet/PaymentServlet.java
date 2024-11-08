/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;
import model.Service;
import model.TypeShift;
import model.User;
import utils.CheckShift;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

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
            out.println("<title>Servlet PaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");
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
            Dao dao = new Dao();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");
            if (user == null) {
                user = dao.getUser(1);
            }
            int idService = Integer.parseInt(request.getParameter("idService"));
            String timeStart = request.getParameter("dateShift");
            String notes = request.getParameter("notes");
            Service service = dao.getService(idService);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(timeStart, formatter);
            Order order = new Order(user, service, notes, "Pending", localDateTime);
            dao.addOrder(order);
            order = dao.getOrder(dao.getAllOrders().getFirst().getIdOrder());
            TypeShift typeShift = dao.getTypeShift(CheckShift.checkHoliday(order.getTimeStart()));
            dao.insertDetailOrder(typeShift.getCoefficient() * service.getPrice(), order.getIdOrder(), typeShift.getIdTypeShift());
            request.getRequestDispatcher("BookingServlet").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Dao dao = new Dao();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");
            if (user == null) {
                user = dao.getUser(1);
            }
            int idService = Integer.parseInt(request.getParameter("idService"));
            String timeStart = request.getParameter("dateShift");
            String notes = request.getParameter("notes");
            Service service = dao.getService(idService);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(timeStart, formatter);
            Order order = new Order(user, service, notes, "Pending", localDateTime);
            dao.addOrder(order);
            order = dao.getOrder(dao.getAllOrders().getFirst().getIdOrder());
            TypeShift typeShift = dao.getTypeShift(CheckShift.checkHoliday(order.getTimeStart()));
            dao.insertDetailOrder(typeShift.getCoefficient() * service.getPrice(), order.getIdOrder(), typeShift.getIdTypeShift());
            request.getRequestDispatcher("BookingServlet").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
