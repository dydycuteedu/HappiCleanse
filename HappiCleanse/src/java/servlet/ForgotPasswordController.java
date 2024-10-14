/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Email;
import model.EmailUtils;
import model.MessageStatus;
import model.User;
import utils.OTPGenerator;


@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/forgotPassword"})
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/forgot-password.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String otp = (String) request.getSession().getAttribute("otp");
        if (otp == null) {
            otp = OTPGenerator.generateNumericOTP(6);
            request.getSession().setAttribute("otp", otp);
        }
        try {
            
            String emailAddress = request.getParameter("email");
            String username = request.getParameter("username");

            Dao dao = new Dao();
            User account = dao.checkAccountExistByUsernameAndEmail(username, emailAddress);
            request.getSession().setAttribute("acc", account);
            if (account == null) {
                request.setAttribute("message", new MessageStatus(2, "Your account not exist"));
                
            }
            if (account != null) {
                Email email = new Email();
                email.setFrom("chumlu2102@gmail.com");
                email.setFromPassword("bjnc zrsr wlqz iyjp");
                email.setTo(emailAddress);
                email.setSubject("Forgot Password Function");
                StringBuilder sb = new StringBuilder();
                sb.append("Dear ").append(username).append("<br>");
                sb.append("You are used the forgot password. <br> ");
                sb.append("Your OTP: <b>").append(otp).append(" </b> <br>");
                sb.append("Regards<br>");
                sb.append("Administrator");
                
                email.setContent(sb.toString());
                EmailUtils.send(email);

                request.setAttribute("message", new MessageStatus(1, "OTP da duoc gui den email cua ban!"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("EnterOTP.jsp").forward(request, response);
    }

}

