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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.User;
import utils.VNPay.VNPayConfig;
import utils.VNPay.VNPayService;


@WebServlet(name = "VNPayServlet", urlPatterns = {"/VNPayServlet"})
public class VNPayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Payment parameters
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TmnCode = "2LAF05XX";  // Get from VNPay
        String vnp_TxnRef = String.valueOf(System.currentTimeMillis()); // Order ID (unique)
        String vnp_OrderInfo = "Payment for order #" + vnp_TxnRef;
        String vnp_OrderType = "billpayment"; // Change if needed
        String vnp_Amount = String.valueOf((Integer.parseInt(req.getParameter("amount")) * 100)); // Amount in VND * 100
        String vnp_Locale = "vn"; // or 'en' for English
        String vnp_ReturnUrl = "http://localhost:8080/HappiCleanse/VNPayServlet"; // The return URL after payment
        String vnp_IpAddr = req.getRemoteAddr(); // User's IP

        // Construct the URL parameters for VNPay
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", vnp_Amount);
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", vnp_OrderType);
        vnp_Params.put("vnp_Locale", vnp_Locale);
        vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        // Add VNPay specific details (signature generation)
        String vnp_HashSecret = "LMY8A1M01U175JJRIUXKXXHTEU1VYPBE"; // Get from VNPay
        String paymentUrl = VNPayConfig.generatePaymentUrl(vnp_Params, vnp_HashSecret);

        // Redirect user to VNPay for payment
        resp.sendRedirect(paymentUrl);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TmnCode = "2LAF05XX";  // Get from VNPay
        String vnp_TxnRef = String.valueOf(System.currentTimeMillis()); // Order ID (unique)
        String vnp_OrderInfo = "Payment for order #" + vnp_TxnRef;
        String vnp_OrderType = "billpayment"; // Change if needed
        String vnp_Amount = String.valueOf(100000 * 100); // Amount in VND * 100
        String vnp_Locale = "vn"; // or 'en' for English
        String vnp_ReturnUrl = "/HappiCleanse/VNPayServlet"; // The return URL after payment
        String vnp_IpAddr = req.getRemoteAddr(); // User's IP

        // Generate current date and time in the required format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String vnp_CreateDate = now.format(formatter);
        
        // Construct the URL parameters for VNPay
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", vnp_Amount);
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", vnp_OrderType);
        vnp_Params.put("vnp_Locale", vnp_Locale);
        vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        // Add VNPay specific details (signature generation)
        String vnp_HashSecret = "LMY8A1M01U175JJRIUXKXXHTEU1VYPBE"; // Get from VNPay
        String paymentUrl = VNPayConfig.generatePaymentUrl(vnp_Params, vnp_HashSecret);
System.out.println(paymentUrl);
        // Redirect user to VNPay for payment
        resp.sendRedirect(paymentUrl);
        
               // Handle the return from VNPay
//        Map<String, String> vnp_ResponseParams = new HashMap<>();
//        req.getParameterMap().forEach((key, value) -> vnp_ResponseParams.put(key, value[0]));
//
//        String vnp_SecureHash = vnp_ResponseParams.get("vnp_SecureHash");
//        vnp_ResponseParams.remove("vnp_SecureHash");
//
//        String vnp_HashSecret = "LMY8A1M01U175JJRIUXKXXHTEU1VYPBE"; // Your VNPay secret key
//        boolean isValidResponse = VNPayConfig.verifyResponse(vnp_ResponseParams, vnp_SecureHash, vnp_HashSecret);
//
//        if (isValidResponse) {
//            // Handle successful payment
//            String transactionStatus = vnp_ResponseParams.get("vnp_ResponseCode");
//            if ("00".equals(transactionStatus)) {
//                resp.getWriter().println("Payment Successful!");
//            } else {
//                resp.getWriter().println("Payment failed with code: " + transactionStatus);
//            }
//        } else {
//            // Handle invalid response
//            resp.getWriter().println("Invalid payment response.");
//        }
    }

}
