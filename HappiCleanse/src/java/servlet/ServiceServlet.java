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
import model.Service;
import model.ServiceCategory;

/**
 *
 * @author CHUC DY
 */
public class ServiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServiceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        List<Service> list = dao.getAllServices();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/service/index.jsp");
        dispatcher.forward(request, response);
    }

    private void Create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/service/create.jsp");
        dispatcher.forward(request, response);
    }
//

    private void View(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();
        int uid = Integer.parseInt(request.getParameter("id"));

        Service service = dao.getService(uid);
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/service/detail.jsp");
        dispatcher.forward(request, response);
    }

    private void Edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int uid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        Service service = dao.getService(uid);
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/service/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void Save(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();

        int uid = Integer.parseInt(request.getParameter("id"));
        int idServiceCategory = Integer.parseInt(request.getParameter("idServiceCategory"));
        String name = request.getParameter("nameService");
        String description = request.getParameter("description");
        
        Service service = dao.getService(uid);

        ServiceCategory servicecategory = dao.getServiceCategory(idServiceCategory);
        service.setServiceCategory(servicecategory);

        service.setNameService(name);
        service.setDescription(description);
        dao.updateService(service);
        Management(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        int rid = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        dao.deleteService(rid);
        Management(request, response);
    }

    //them moi vao trong db
    private void Add(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, Exception {
        Dao dao = new Dao();
        int idServiceCategory = Integer.parseInt(request.getParameter("idServiceCategory"));
        String name = request.getParameter("nameService");

        String description = request.getParameter("description");
        String img1 = request.getParameter("img1");
        String img2 = request.getParameter("img2");
        String img3 = request.getParameter("img3");
        double price = Double.parseDouble(request.getParameter("price"));

        ServiceCategory servicecategory = dao.getServiceCategory(idServiceCategory);
        Service service = new Service();

        service.setServiceCategory(servicecategory);
        service.setNameService(name);
        service.setDescription(description);
        service.setImg1(img1);
        service.setImg2(img2);
        service.setImg3(img3);
        service.setPrice(price);

        dao.addService(service);
        Management(request, response);
    }
}
