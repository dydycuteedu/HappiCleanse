/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "SignUpController", urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("nameUser");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");
        if (!pass.equals(re_pass)) {
            response.sendRedirect("HappiCleanse/login.jsp");
        } else {
            Dao dao = new Dao();
            User a = dao.checkAccountExist(user);
            if (a == null) {
                try {
                    //dc signup
                    dao.singup(name, user, pass, email);
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("/HappiCleanse/login");
            } else {
                //day ve trang login.jsp
                response.sendRedirect("login.jsp");
            }
        }
        //sign up
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
