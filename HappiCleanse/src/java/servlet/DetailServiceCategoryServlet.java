/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Service;
import model.ServiceCategory;

/**
 *
 * @author CHUC DY
 */
public class DetailServiceCategoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Dao dao = new Dao();
            int idServiceCategory = Integer.parseInt(request.getParameter("idServiceCategory"));
            ServiceCategory servicecategory = dao.getServiceCategory(idServiceCategory);
            List<Service> service = dao.getAllServicesbycategoryid(idServiceCategory);
            request.setAttribute("servicecategory", servicecategory);
            request.setAttribute("service", service);
            request.getRequestDispatcher("DetailServiceCategory.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DetailServiceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Dao dao = new Dao();
            int idServiceCategory = Integer.parseInt(request.getParameter("idServiceCategory"));
            ServiceCategory servicecategory = dao.getServiceCategory(idServiceCategory);
            List<Service> service = dao.getAllServicesbycategoryid(idServiceCategory);
            request.setAttribute("servicecategory", servicecategory);
            request.setAttribute("service", service);
            request.getRequestDispatcher("DetailServiceCategory.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DetailServiceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>}
}
