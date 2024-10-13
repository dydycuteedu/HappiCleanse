/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/uploadAvatar")
public class UploadAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the request is a multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // Set up file upload handler
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        String uploadPath = "path/to/uploads" + File.separator + name;
                        item.write(new File(uploadPath));

                        // Update the session attribute with the new avatar URL
                        request.getSession().setAttribute("acc.avatar", "path/to/uploads/" + name);
                    }
                }

                // Redirect to profile page after upload
                response.sendRedirect("profile.jsp");
            } catch (Exception e) {
                request.setAttribute("message", "File upload failed due to: " + e.getMessage());
            }
        } else {
            request.setAttribute("message", "Sorry, this servlet only handles file upload request.");
        }
    }
}

