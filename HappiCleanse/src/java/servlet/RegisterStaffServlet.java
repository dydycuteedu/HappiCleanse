/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Email;
import model.EmailUtils;
import model.User;

/**
 *
 * @author CHUC DY
 */
@MultipartConfig
public class RegisterStaffServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterStaffServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterStaffServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
            Part filePart = request.getPart("CV");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("/") + "img";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            User user = new User();
            user.setCvUrl("img/" + fileName);
            user.setEmail(emailAddress);
            user.setFullname(firstName + " " + lastName);
            user.setIsCheck(0);
            user.setIsValid(1);
            user.setUsername(lastName);
            user.setRole("Staff");
            user.setPassword("111");
            user.setPhonenumber(phone);
            user.setGender(gender);
            Dao dao = new Dao();
            if (dao.registerStaff(user)) {
                Email email = new Email();
                email.setFrom("trantrucvy265@gmail.com");
                email.setFromPassword("igww uwrd ytua jmja");
                email.setTo(emailAddress);
                email.setSubject("Welcome to HappiCleanse!!!");
                StringBuilder sb = new StringBuilder();
                sb.append("Dear ").append(firstName + " " + lastName).append("<br>");
                sb.append("You have just registered to be a cleaning staff at HappiCleanse. <br> ");
                sb.append("Please wait, we will review your application and notify you as soon as possible. <br> ");
                sb.append("Regards<br>");
                sb.append("Administrator");

                email.setContent(sb.toString());
                EmailUtils.send(email);
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("Hiring.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("Hiring.jsp").forward(request, response);
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
