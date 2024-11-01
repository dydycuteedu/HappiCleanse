/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;
import model.Shifts;
import model.TypeShift;
import model.User;
import model.WorkingHour;
import utils.CheckShift;

/**
 *
 * @author CHUC DY
 */
public class StaffWorkingServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet StaffWorkingServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffWorkingServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
            User a = (User) session.getAttribute("acc");
            List<Order> orderList = dao.getOrderByStaffId(a.getIdUser());
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("StaffWorkingList.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(StaffWorkingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("id"));
            Dao dao = new Dao();
            Order order = dao.getOrder(idOrder);
            order.setTimeEnd(LocalDateTime.now());
            order.setStatusOrder("Check Out");
            dao.completeOrder(order);
            int hoursDifference = (int) Duration.between(order.getTimeStart(), order.getTimeEnd()).toHours();
            if(hoursDifference < 1){
                hoursDifference = 1;
            }
            TypeShift typeShift = dao.getTypeShift(CheckShift.checkHoliday(order.getTimeStart()));
            WorkingHour wk = dao.getWorkingHourbyHours(hoursDifference);
            Shifts shift = new Shifts(typeShift, wk.getPricePerHour());
            dao.addShift(shift);
            List<Shifts> shifts = dao.getAllShifts();
            dao.insertDetailOrder(typeShift.getCoefficient() * shift.getPrice() * hoursDifference, order.getIdOrder(), shifts.getLast().getIdShift());
            doGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(StaffWorkingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
