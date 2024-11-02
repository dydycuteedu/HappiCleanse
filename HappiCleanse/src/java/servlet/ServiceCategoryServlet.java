/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceCategory;
import model.User;

/**
 *
 * @author CHUC DY
 */
public class ServiceCategoryServlet extends HttpServlet {

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
            out.println("<title>Servlet ServiceCategoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServiceCategoryServlet at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ServiceCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();
        List<ServiceCategory> list = dao.getAllServiceCategories();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/servicecategory/index.jsp");
        dispatcher.forward(request, response);
    }

    //dan toi trang add new jsp
    private void Create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/servicecategory/create.jsp");
        dispatcher.forward(request, response);
    }
//

    private void View(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();
        int uid = Integer.parseInt(request.getParameter("id"));

        ServiceCategory servicecategory = dao.getServiceCategory(uid);
        request.setAttribute("servicecategory", servicecategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/servicecategory/detail.jsp");
        dispatcher.forward(request, response);
    }

    private void Edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int uid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        ServiceCategory servicecategory = dao.getServiceCategory(uid);
        request.setAttribute("servicecategory", servicecategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/servicecategory/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void Save(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int uid = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameServiceCategory");
        String subDescription = request.getParameter("subDescription");
        String description = request.getParameter("description");

        Dao dao = new Dao();

        ServiceCategory servicecategory = dao.getServiceCategory(uid);
        servicecategory.setNameServiceCategory(name);
        servicecategory.setSubDescription(subDescription);
        servicecategory.setDescription(description);

        dao.updateServiceCategory(servicecategory);
        Management(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int rid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        dao.deleteServiceCategory(rid);
        Management(request, response);
    }

    //them moi vao trong db
    private void Add(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        String name = request.getParameter("nameServiceCategory");
        String subDescription = request.getParameter("subDescription");
        String description = request.getParameter("description");
        String imgURL = request.getParameter("imgURL");
        Dao dao = new Dao();
        ServiceCategory servicecategory = new ServiceCategory();
        servicecategory.setNameServiceCategory(name);
        servicecategory.setSubDescription(subDescription);
        servicecategory.setDescription(description);
        servicecategory.setImgURL(imgURL);
        
        dao.addServiceCategory(servicecategory);
        Management(request, response);
    }
}
