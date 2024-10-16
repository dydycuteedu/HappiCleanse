/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.mail.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/uploadAvatar")
public class UploadAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the request is a multipart/form-data
        HttpSession session = request.getSession(false);
        // Lấy file từ input form
        Part filePart = request.getPart("avatar"); // "imageFile" là tên của input field

        // Lấy tên file gốc
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Đường dẫn đến thư mục muốn lưu file (bạn có thể thay đổi thành thư mục mong muốn)
        String uploadPath = getServletContext().getRealPath("/") + "/img";

        // Tạo thư mục nếu nó chưa tồn tại
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Đường dẫn đầy đủ của file sẽ được lưu
        String filePath = uploadPath + File.separator + fileName;

        // Ghi file vào đường dẫn trên
        filePart.write(filePath);
        UserDetail userDetail = (UserDetail) session.getAttribute("accDetail");

        userDetail.setAvatar("views/client/asset/img/" + fileName);

        UserDetailDao userDetailDao = new UserDetailDao();
        boolean isUpdatedUserImg = userDetailDao.updateUserDetailProfile(userDetail);
        
        if (isUpdatedUserImg) {
            session.setAttribute("msg", "Cập nhật hồ sơ thành công!");
            session.setAttribute("accDetail", userDetail);
        } else {
            // Gửi phản hồi lại cho người dùng
            session.setAttribute("msg", "Có lỗi xảy ra trong quá trình cập nhật!");
        }
        request.getRequestDispatcher("views/client/pages/profile.jsp").forward(request, response);
    }
}

