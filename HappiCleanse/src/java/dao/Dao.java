/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.Address;
import model.DetailShifts;
import model.Feedback;
import model.Notification;
import model.Order;
import model.Service;
import model.Shifts;
import model.ServiceCategory;
import model.TypeShift;
import model.User;
import utils.BCryptPassword;
import utils.ConvertConstant;

public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User login(String user, String pass) {
        String query = "select * from Users\n"
                + "where username = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (BCryptPassword.checkP(pass, rs.getString("password"))) {

                    return new User(
                            rs.getInt("idUser"),
                            rs.getString("fullname"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("phonenumber"),
                            rs.getString("gender"),
                            rs.getString("avatar"),
                            rs.getString("address"),
                            rs.getInt("isValid"),
                            rs.getInt("isCheck"),
                            rs.getString("Role"),
                            rs.getString("CVURL")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User checkAccountExist(String user) {
        String query = "select * from Users\n"
                + "where username = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new User(
                        rs.getInt("idUser"),
                        rs.getString("fullname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        rs.getString("address"),
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role"),
                        rs.getString("CVURL")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUser(int idUser) {
        String sql = "SELECT * FROM Users where idUser = ?";
        try {
            conn = DBContext.getConnection();
            PreparedStatement pss = conn.prepareStatement(sql);
            pss.setInt(1, idUser);
            rs = pss.executeQuery();
            if (rs.next()) {

                return new User(
                        rs.getInt("idUser"),
                        rs.getString("fullname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        rs.getString("address"),
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role"),
                        rs.getString("CVURL")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<User>();

        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPhonenumber(rs.getString(6));
                u.setGender(rs.getString(7));
                u.setAvatar(rs.getString(8));
                u.setAddress(rs.getString(9));
                u.setIsValid(rs.getInt(10));
                u.setIsCheck(rs.getInt(11));
                u.setRole(rs.getString(12));
                u.setCvUrl(rs.getString(13));
                list.add(u);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public User checkAccountExistByUsernameAndEmail(String username, String email) {
        String query = "select * from Users\n"
                + "where username = ? AND email = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new User(
                        rs.getInt("idUser"),
                        rs.getString("fullname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        rs.getString("address"),
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role"),
                        rs.getString("CVURL")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void editProfile(User user) throws Exception {
        String sql = "UPDATE Users SET fullname = ?, username = ?, password = ?, email = ?, phonenumber = ?, gender = ?, address = ?, isValid = ? WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhonenumber());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getAddress());
            ps.setInt(8, user.getIsValid());
            ps.setInt(9, user.getIdUser());
            ps.executeUpdate();
        }
    }
    
    public void approveStaff(User user) throws Exception {
        String sql = "UPDATE Users SET isCheck = ? WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getIsCheck());
            ps.setInt(2, user.getIdUser());
            ps.executeUpdate();
        }
    }
    
    public void denyStaff(User user) throws Exception {
        String sql = "UPDATE Users SET isValid = ? WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getIsValid());
            ps.setInt(2, user.getIdUser());
            ps.executeUpdate();
        }
    }

    public boolean singup(String fullname, String username, String pass, String email) throws SQLException {
        String sql = "INSERT INTO Users (fullname, username, password, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fullname);
            ps.setString(2, username);
            ps.setString(3, BCryptPassword.hash(pass));
            ps.setString(4, email);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
//sign up staff with full profile
    
    public boolean registerStaff(User user) throws SQLException {
        String sql = "INSERT INTO Users (fullname, username, password, email,phonenumber,gender,isValid,isCheck,Role,CVURL) VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, BCryptPassword.hash(user.getPassword()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhonenumber());
            ps.setString(6, user.getGender());
            ps.setInt(7, user.getIsValid());
            ps.setInt(8, user.getIsCheck());
            ps.setString(9, user.getRole());
            ps.setString(10, user.getCvUrl());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean singupStaff(String fullname, String username, String pass, String email, String phonenumber, String address, String gender, String avatar) throws SQLException {
        String sql = "INSERT INTO Users (fullname, username, password, email, phonenumber, address, gender, avatar, role, isValid,isCheck) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,1)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fullname);
            ps.setString(2, username);
            ps.setString(3, BCryptPassword.hash(pass));
            ps.setString(4, email);
            ps.setString(5, phonenumber);
            ps.setString(6, address);
            ps.setString(7, gender);
            ps.setString(8, avatar);
            ps.setString(9, "Staff");
            ps.setInt(10, 1);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //delete staff
    public void deleteStaff(int id) throws SQLException, Exception {
        String sql = "UPDATE Users set isValid = 0 WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public void unbanUser(int id) throws SQLException, Exception {
        String sql = "UPDATE Users set isValid = 1 WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
   
    public void changePassword(String password, int idUser) {
        String sql = "UPDATE Users set password = ? WHERE idUser = ? ";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, BCryptPassword.hash(password));
            ps.setInt(2, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Notification 28/09
    public void addNotification(Notification notification) throws SQLException, Exception {
        String sql = "INSERT INTO Notification (idUser, content) VALUES (?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, notification.getUser().getIdUser());
            ps.setString(2, notification.getContent());
            ps.executeUpdate();
        }
    }

    public Notification getNotification(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Notification WHERE idNotification = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = getUser(rs.getInt("idUser"));
                    return new Notification(rs.getInt("idNotification"), user, rs.getString("content"));
                }
            }
        }
        return null;
    }

    public List<Notification> getAllNotifications() throws SQLException, Exception {
        String sql = "SELECT * FROM Notification";
        List<Notification> notifications = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = getUser(rs.getInt("idUser"));
                notifications.add(new Notification(rs.getInt("idNotification"), user, rs.getString("content")));
            }
        }
        return notifications;
    }

    public void updateNotification(Notification notification) throws SQLException, Exception {
        String sql = "UPDATE Notification SET idUser = ?, content = ? WHERE idNotification = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, notification.getUser().getIdUser());
            ps.setString(2, notification.getContent());
            ps.setInt(3, notification.getIdNotification());
            ps.executeUpdate();
        }
    }

    public void deleteNotification(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Notification WHERE idNotification = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // order 28/09
    public void addOrder(Order order) throws SQLException, Exception {
        String sql = "INSERT INTO Orders (idUser, notes, statusOrder, dateCreate,dateService) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getUser().getIdUser());
            ps.setString(2, order.getNotes());
            ps.setString(3, order.getStatusOrder());
            ps.setDate(4, ConvertConstant.convertLocalDateToDate(LocalDateTime.now()));
            // Định dạng ngày giờ theo ý muốn
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateServiceString = order.getDateService().format(formatter);
            ps.setString(5, dateServiceString);
            ps.executeUpdate();
        }
    }

    public Order getOrder(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Orders WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = getUser(rs.getInt("idUser"));
                    User staff = getUser(rs.getInt("idStaff"));
                    Shifts shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                    return new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), ConvertConstant.convertDateToLocalDate(rs.getDate("dateService")), shifts,staff);
                }
            }
        }
        return null;
    }
    
     public List<Order> getOrderinprogressbystaffID(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Orders WHERE idStaff = ? and statusOrder = 'In Progress'";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = getUser(rs.getInt("idUser"));
                    User staff = getUser(rs.getInt("idStaff"));
                    Shifts shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                    orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), ConvertConstant.convertDateToLocalDate(rs.getDate("dateService")), shifts,staff));
                }
            }
        }
        return orders;
    }

    public List<Order> getAllOrders() throws SQLException, Exception {
        String sql = "SELECT * FROM Orders ORDER by idOrder desc";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                User user = getUser(rs.getInt("idUser"));
                User staff = getUser(rs.getInt("idStaff"));
                Shifts shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), ConvertConstant.convertDateToLocalDate(rs.getDate("dateService")), shifts,staff));
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException, Exception {
        String sql = "UPDATE Orders SET idUser = ?, notes = ?, statusOrder = ? WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getUser().getIdUser());
            ps.setString(2, order.getNotes());
            ps.setString(3, order.getStatusOrder());
            ps.setInt(4, order.getIdOrder());
            ps.executeUpdate();
        }
    }
    
    public void updateStaffOrder(Order order) throws SQLException, Exception {
        String sql = "UPDATE Orders SET idStaff = ?, statusOrder = ? WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getStaff().getIdUser());
            ps.setString(2, order.getStatusOrder());
            ps.setInt(3, order.getIdOrder());
            ps.executeUpdate();
        }
    }

    public void deleteOrder(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Orders WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void cancelOrder(Order order) throws SQLException, Exception {
        String sql = "UPDATE Orders SET statusOrder = ? WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, order.getStatusOrder());
            ps.setInt(2, order.getIdOrder());
            ps.executeUpdate();
        }
    }

    // Type shifts 28/09
    public TypeShift getTypeShift(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM TypeShift WHERE idTypeShift = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new TypeShift(rs.getInt("idTypeShift"), rs.getString("colorTypeShift"), rs.getDouble("coefficient"));
                }
            }
        }
        return null;
    }

    public List<TypeShift> getAllTypeShifts() throws SQLException, Exception {
        String sql = "SELECT * FROM TypeShift";
        List<TypeShift> typeShifts = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                typeShifts.add(new TypeShift(rs.getInt("idTypeShift"), rs.getString("colorTypeShift"), rs.getDouble("coefficient")));
            }
        }
        return typeShifts;
    }

    // Shift 28/09
    public void addShift(Shifts shift) throws SQLException, Exception {
        String sql = "INSERT INTO Shifts (idTypeShift, price) VALUES (?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, shift.getTypeShift().getIdTypeShift());
            ps.setDouble(2, shift.getPrice());
            ps.executeUpdate();
        }
    }

    public Shifts getAllShiftByOrder(int orderId) {
        String sql = "SELECT s.*\n"
                + "FROM Shifts s\n"
                + "JOIN DetailOrder d ON s.idShift = d.idShift\n"
                + "WHERE d.idOrder = ?";
        Shifts shifts = new Shifts();
        try (Connection conn = DBContext.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypeShift typeShift = getTypeShift(rs.getInt("idTypeShift"));
                shifts = new Shifts(rs.getInt("idShift"), typeShift, rs.getDouble("price"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shifts;
    }

    public Shifts getShift(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Shifts WHERE idShift = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TypeShift typeShift = getTypeShift(rs.getInt("idTypeShift"));
                    return new Shifts(rs.getInt("idShift"), typeShift, rs.getDouble("price"));
                }
            }
        }
        return null;
    }

    public List<Shifts> getAllShifts() throws SQLException, Exception {
        String sql = "SELECT * FROM Shifts";
        List<Shifts> shifts = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TypeShift typeShift = getTypeShift(rs.getInt("idTypeShift"));
                shifts.add(new Shifts(rs.getInt("idShift"), typeShift, rs.getDouble("price")));
            }
        }
        return shifts;
    }

    public void updateShift(Shifts shift) throws SQLException, Exception {
        String sql = "UPDATE Shifts SET idTypeShift = ?, price = ? WHERE idShift = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, shift.getTypeShift().getIdTypeShift());
            ps.setDouble(2, shift.getPrice());
            ps.setInt(3, shift.getIdShift());
            ps.executeUpdate();
        }
    }

    public void deleteShift(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Shifts WHERE idShift = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    //feedback 28/09
    public void addFeedback(Feedback feedback) throws SQLException, Exception {
        String sql = "INSERT INTO Feedback (contentFeedback, ratings, editedTime, idOrder, idUser) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getContentFeedback());
            ps.setInt(2, feedback.getRatings());
            ps.setDate(3, ConvertConstant.convertLocalDateToDate(LocalDateTime.now()));
            ps.setInt(4, feedback.getOrder().getIdOrder());
            ps.setInt(5, feedback.getUser().getIdUser());
            ps.executeUpdate();
        }
    }
//
//    // Method to retrieve a Feedback by its ID
//    public Feedback getFeedback(int id) throws SQLException, Exception {
//        String sql = "SELECT * FROM Feedback WHERE idFeedback = ?";
//        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    Shifts shift = getShift(rs.getInt("idShift"));
//                    User user = getUser(rs.getInt("idUser"));
//                    return new Feedback(
//                            rs.getInt("idFeedback"),
//                            rs.getString("contentFeedback"),
//                            rs.getInt("ratings"),
//                            rs.getTimestamp("editedTime").toLocalDateTime(),
//                            shift,
//                            user
//                    );
//                }
//            }
//        }
//        return null;
//    }
    // Method to retrieve all Feedback entries

    public List<Feedback> getAllFeedbacks() throws SQLException, Exception {
        String sql = "SELECT * FROM Feedback";
        List<Feedback> feedbacks = new ArrayList<>();
        try (Connection connh = DBContext.getConnection(); PreparedStatement pss = connh.prepareStatement(sql)) {
            ResultSet rsH = pss.executeQuery();
            while (rsH.next()) {
                Order order = getOrder(rsH.getInt("idOrder"));
                User user = getUser(rsH.getInt("idUser"));
                feedbacks.add(new Feedback(
                        rsH.getInt("idFeedback"),
                        rsH.getString("contentFeedback"),
                        rsH.getInt("ratings"),
                        rsH.getDate("editedTime").toLocalDate(),
                        order,
                        user
                ));
            }
        }
        System.out.println(feedbacks.toString());
        return feedbacks;
    }

    // Method to update a Feedback entry
//    public void updateFeedback(Feedback feedback) throws SQLException, Exception {
//        String sql = "UPDATE Feedback SET contentFeedback = ?, ratings = ?, editedTime = ?, idShift = ?, idUser = ? WHERE idFeedback = ?";
//        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, feedback.getContentFeedback());
//            ps.setInt(2, feedback.getRatings());
//            ps.setTimestamp(3, Timestamp.valueOf(feedback.getEditedTime()));
//            ps.setInt(4, feedback.getShift().getIdShift());
//            ps.setInt(5, feedback.getUser().getIdUser());
//            ps.setInt(6, feedback.getIdFeedback());
//            ps.executeUpdate();
//        }
//    }
    // Method to delete a Feedback entry by its ID
    public void deleteFeedback(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Feedback WHERE idFeedback = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

//    public List<Feedback> getFeedbackByService(int idService) throws Exception {
//        String sql = "SELECT \n"
//                + "    f.idFeedback,\n"
//                + "    f.contentFeedback,\n"
//                + "    f.ratings,\n"
//                + "    f.editedTime,\n"
//                + "    s.idService\n"
//                + "FROM \n"
//                + "    Feedback f\n"
//                + "JOIN \n"
//                + "    Shifts sh ON f.idShift = sh.idShift\n"
//                + "JOIN \n"
//                + "    Service s ON sh.idShift = s.idService \n"
//                + "WHERE \n"
//                + "    idService = ?";
//        List<Feedback> feedbacks = new ArrayList<>();
//        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, idService);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Shifts shift = getShift(rs.getInt("idShift"));
//                User user = getUser(rs.getInt("idUser"));
//                feedbacks.add(new Feedback(
//                        rs.getInt("idFeedback"),
//                        rs.getString("contentFeedback"),
//                        rs.getInt("ratings"),
//                        rs.getTimestamp("editedTime").toLocalDateTime(),
//                        shift,
//                        user
//                ));
//            }
//        }
//        return feedbacks;
//    }
    // service
    public void addService(Service service) throws SQLException, Exception {
        String sql = "INSERT INTO Service (nameService, description, img1, img2, img3, idServiceCategory) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescription());
            stmt.setString(3, service.getImg1());
            stmt.setString(4, service.getImg2());
            stmt.setString(5, service.getImg3());
            stmt.setInt(6, service.getServiceCategory().getIdServiceCategory());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    service.setIdService(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Service getService(int idService) throws SQLException, Exception {
        String sql = "SELECT * FROM Service WHERE idService = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idService);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapService(rs);
                }
            }
        }
        return null;
    }

    public List<Service> getAllServices() throws SQLException, Exception {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM Service";
        try (Connection connn = DBContext.getConnection(); PreparedStatement stmt = connn.prepareStatement(sql);) {
            ResultSet rsH = stmt.executeQuery();
            while (rsH.next()) {
                services.add(mapService(rsH));
            }
        }
        return services;
    }

    public void updateService(Service service) throws SQLException, Exception {
        String sql = "UPDATE Service SET nameService = ?, description = ?, img1 = ?, img2 = ?, img3 = ?, idServiceCategory = ? WHERE idService = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescription());
            stmt.setString(3, service.getImg1());
            stmt.setString(4, service.getImg2());
            stmt.setString(5, service.getImg3());
            stmt.setInt(6, service.getServiceCategory().getIdServiceCategory());
            stmt.setInt(7, service.getIdService());
            stmt.executeUpdate();
        }
    }

    public void deleteService(int idService) throws SQLException, Exception {
        String sql = "DELETE FROM Service WHERE idService = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idService);
            stmt.executeUpdate();
        }
    }

    private Service mapService(ResultSet rs) throws SQLException, Exception {
        Service service = new Service();
        service.setIdService(rs.getInt("idService"));
        service.setNameService(rs.getString("nameService"));
        service.setDescription(rs.getString("description"));
        service.setImg1(rs.getString("img1"));
        service.setImg2(rs.getString("img2"));
        service.setImg3(rs.getString("img3"));

        // Assuming you have a ServiceCategoryDAO to get ServiceCategory by id
        ServiceCategory serviceCategory = getServiceCategory(rs.getInt("idServiceCategory"));
        service.setServiceCategory(serviceCategory);
        return service;
    }

    //get Service Category
    public ServiceCategory getServiceCategory(int idServiceCategory) throws SQLException, Exception {
        String sql = "SELECT * FROM ServiceCategory WHERE idServiceCategory = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idServiceCategory);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapServiceCategory(rs);
                }
            }
        }
        return null;
    }

    public List<ServiceCategory> getAllServiceCategories() throws SQLException, Exception {
        List<ServiceCategory> serviceCategories = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ServiceCategory");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                serviceCategories.add(mapServiceCategory(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceCategories;
    }

    private ServiceCategory mapServiceCategory(ResultSet rs) throws SQLException {
        ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setIdServiceCategory(rs.getInt("idServiceCategory"));
        serviceCategory.setNameServiceCategory(rs.getString("nameServiceCategory"));
        serviceCategory.setImgURL(rs.getString("imgURL"));
        return serviceCategory;
    }

    public Iterable<Service> getServiceBySearchContent(String search) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable<Service> getServiceByCategory(String searchCategory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<User> getAllStaff() {
        List<User> list = new ArrayList<User>();

        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Users where Role = ?");
            ps.setString(1, "Staff");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPhonenumber(rs.getString(6));
                u.setGender(rs.getString(7));
                u.setAvatar(rs.getString(8));
                u.setAddress(rs.getString(9));
                u.setIsValid(rs.getInt(10));
                u.setIsCheck(rs.getInt(11));
                u.setRole(rs.getString(12));
                if(list.size()<4){
                    list.add(u);
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Order> getOrderByUserId(int idUser) throws Exception {
        String sql = "SELECT * FROM Orders WHERE idUser = ? ORDER by idOrder desc";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUser(rs.getInt("idUser"));
                User staff = getUser(rs.getInt("idStaff"));
                Shifts shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), ConvertConstant.convertDateToLocalDate(rs.getDate("dateService")), shifts,staff));
            }
        }
        return orders;
    }
    public List<Order> getOrderByStaffId(int idUser) throws Exception {
        String sql = "SELECT * FROM Orders WHERE idStaff = ? ORDER by idOrder desc";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUser(rs.getInt("idUser"));
                User staff = getUser(rs.getInt("idStaff"));
                Shifts shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), ConvertConstant.convertDateToLocalDate(rs.getDate("dateService")), shifts,staff));
            }
        }
        return orders;
    }

    // DETAIL SHIFT
    public void insertDetailShift(DetailShifts detailShift) throws Exception {
        String sql = "INSERT INTO DetailShift (idShifts, idUser, idService) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, detailShift.getShifts().getIdShift());
            ps.setInt(2, detailShift.getUser().getIdUser());
            ps.setInt(3, detailShift.getService().getIdService());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Get a specific DetailShift)
    public DetailShifts getDetailShift(int idShift) throws Exception {
        String sql = "SELECT * FROM DetailShift WHERE idShifts = ?";
        DetailShifts detailShift = null;

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idShift);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                detailShift = new DetailShifts(
                        getShift(rs.getInt("idShifts")),
                        getUser(rs.getInt("idUser")),
                        getService(rs.getInt("idService"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailShift;
    }

    // Read All (Get all DetailShifts)
    public List<DetailShifts> getAllDetailShifts() throws Exception {
        String sql = "SELECT * FROM DetailShift";
        List<DetailShifts> detailShifts = new ArrayList<>();

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetailShifts detailShift = new DetailShifts(
                        getShift(rs.getInt("idShifts")),
                        getUser(rs.getInt("idUser")),
                        getService(rs.getInt("idService"))
                );
                detailShifts.add(detailShift);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailShifts;
    }

    // Update
    public void updateDetailShift(DetailShifts detailShift) throws Exception {
        String sql = "UPDATE DetailShift SET idUser = ?, idService = ? WHERE idShifts = ?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, detailShift.getShifts().getIdShift());
            ps.setInt(2, detailShift.getUser().getIdUser());
            ps.setInt(3, detailShift.getService().getIdService());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteDetailShift(int idShift, int idUser, int idService) throws Exception {
        String sql = "DELETE FROM DetailShift WHERE idShifts = ? AND idUser = ? AND idService = ?";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idShift);
            ps.setInt(2, idUser);
            ps.setInt(3, idService);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT DETAIL ORDER
    public void insertDetailOrder(double totalMoney, int idOrder, int idShifts) throws Exception {
        String sql = "INSERT INTO DetailOrder (totalMoney, idOrder, idShift) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setDouble(1, totalMoney);
            ps.setInt(2, idOrder);
            ps.setInt(3, idShifts);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // GET SHIFT BY ID ORDER
    public Shifts getShiftsByIdOrder(int idOrder) throws Exception {
        String sql = "SELECT idShift FROM DetailOrder WHERE idOrder = ?";
        List<Shifts> shifts = new ArrayList<>();

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idOrder);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idShift = rs.getInt("idShift");
                shifts.add(getShift(idShift)); // Add the shift to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shifts.getLast();
    }
    

    // GET SERVICE BY SHIFTS
    public List<Service> getServiceByShift(int idShift) throws Exception {
        String sql = "SELECT s.idService, s.nameService, s.description, s.img1, s.img2, s.img3, idServiceCategory "
                + "FROM DetailShift ds "
                + "JOIN Service s ON ds.idService = s.idService "
                + "WHERE ds.idShifts = ?";
        List<Service> services = new ArrayList<>();

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idShift);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ServiceCategory serviceCategory = getServiceCategory(rs.getInt("idServiceCategory"));
                Service service = new Service(
                        rs.getInt("idService"),
                        rs.getString("nameService"),
                        rs.getString("description"),
                        rs.getString("img1"),
                        rs.getString("img2"),
                        rs.getString("img3"),
                        serviceCategory
                );
                services.add(service); // Add the service to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }

}
