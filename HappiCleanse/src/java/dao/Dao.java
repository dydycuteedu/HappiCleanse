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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Address;
import model.DetailShifts;
import model.Feedback;
import model.Notification;
import model.Order;
import model.Service;
import model.Shifts;
import model.TypeService;
import model.TypeShift;
import model.User;
import utils.BCryptPassword;
import utils.ConvertConstant;

/**
 *
 * @author codevn
 */
public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User login(String user, String pass) {
        String query = "select * from [User]\n"
                + "where [username] = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (BCryptPassword.checkP(pass, rs.getString("password"))) {
                    Address address = getAddress(rs.getInt("address"));
                    return new User(
                        rs.getInt("idUser"),
                        rs.getString("nameUser"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        address,
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role")
                );
            }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User checkAccountExist(String user) {
        String query = "select * from [User]\n"
                + "where username = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address address = getAddress(rs.getInt("address"));
                return new User(
                        rs.getInt("idUser"),
                        rs.getString("nameUser"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        address,
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUser(int idUser) {
        String sql = "SELECT * FROM [User] where idUser = ?";
        try {
            conn = DBContext.getConnection();
            PreparedStatement pss = conn.prepareStatement(sql);
            pss.setInt(1, idUser);
            rs = pss.executeQuery();
            if (rs.next()) {
                Address address = getAddress(rs.getInt("address"));
                return new User(
                        rs.getInt("idUser"),
                        rs.getString("nameUser"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        address,
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User checkAccountExistByUsernameAndEmail(String username, String email) {
        String query = "select * from [User]\n"
                + "where username = ? AND email = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address address = getAddress(rs.getInt("address"));
                return new User(
                        rs.getInt("idUser"),
                        rs.getString("nameUser"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getString("gender"),
                        rs.getString("avatar"),
                        address,
                        rs.getInt("isValid"),
                        rs.getInt("isCheck"),
                        rs.getString("Role")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void editProfile(User user) throws Exception {
        String sql = "UPDATE [User] SET nameUser = ?, username = ?, password = ?, email = ?, phonenumber = ?, gender = ?,avatar=?, address = ? WHERE idUser = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getNameUser());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhonenumber());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getAvatar());
            ps.setInt(8, user.getAddress().getIdAddress());
            ps.setInt(9, user.getIdUser());
            ps.executeUpdate();
        }
    }

    public boolean singup(String nameUser, String username, String pass, String email) throws SQLException {
        String sql = "INSERT INTO [User] (nameUser, username, password, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nameUser);
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

    public void changePassword(String password, int idUser) {
        String sql = "UPDATE [User] set password = ? WHERE idUser = ? ";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, BCryptPassword.hash(password));
            ps.setInt(2, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ADDRESS 28/09
    public void addAddress(Address address) throws SQLException, Exception {
        String sql = "INSERT INTO Address (street, district, city, zipcode) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, address.getStreet());
            ps.setString(2, address.getDistrict());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getZipcode());
            ps.executeUpdate();
        }
    }

    public Address getAddress(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Address WHERE idAddress = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Address(
                            rs.getInt("idAddress"),
                            rs.getString("street"),
                            rs.getString("district"),
                            rs.getString("city"),
                            rs.getString("zipcode")
                    );
                }
            }
        }
        return null;
    }

    public List<Address> getAllAddresses() throws SQLException, Exception {
        String sql = "SELECT * FROM Address";
        List<Address> addresses = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                addresses.add(new Address(
                        rs.getInt("idAddress"),
                        rs.getString("street"),
                        rs.getString("district"),
                        rs.getString("city"),
                        rs.getString("zipcode")
                ));
            }
        }
        return addresses;
    }

    public void updateAddress(Address address) throws SQLException, Exception {
        String sql = "UPDATE Address SET street = ?, district = ?, city = ?, zipcode = ? WHERE idAddress = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, address.getStreet());
            ps.setString(2, address.getDistrict());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getZipcode());
            ps.setInt(5, address.getIdAddress());
            ps.executeUpdate();
        }
    }

    public void deleteAddress(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Address WHERE idAddress = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
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
        String sql = "INSERT INTO [Order] (idUser, notes, statusOrder, dateCreate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getUser().getIdUser());
            ps.setString(2, order.getNotes());
            ps.setString(3, order.getStatusOrder());
            ps.setDate(4, ConvertConstant.convertLocalDateToDate(LocalDateTime.now()));
            ps.executeUpdate();
        }
    }

    public Order getOrder(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM [Order] WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = getUser(rs.getInt("idUser"));
                    List<Shifts> shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                    return new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), shifts);
                }
            }
        }
        return null;
    }

    public List<Order> getAllOrders() throws SQLException, Exception {
        String sql = "SELECT * FROM [Order]";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                User user = getUser(rs.getInt("idUser"));
                List<Shifts> shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), shifts));
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException, Exception {
        String sql = "UPDATE [Order] SET idUser = ?, notes = ?, statusOrder = ? WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getUser().getIdUser());
            ps.setString(2, order.getNotes());
            ps.setString(3, order.getStatusOrder());
            ps.setInt(4, order.getIdOrder());
            ps.executeUpdate();
        }
    }

    public void deleteOrder(int id) throws SQLException, Exception {
        String sql = "DELETE FROM [Order] WHERE idOrder = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
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

    public List<Shifts> getAllShiftByOrder(int orderId) {
        String sql = "SELECT s.*\n"
                + "FROM Shifts s\n"
                + "JOIN DetailOrder d ON s.idShift = d.idShift\n"
                + "WHERE d.idOrder = ?";
        List<Shifts> shifts = new ArrayList<>();
        try (Connection conn = DBContext.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypeShift typeShift = getTypeShift(rs.getInt("idTypeShift"));
                shifts.add(new Shifts(rs.getInt("idShift"), typeShift, rs.getDouble("price")));
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

    // feedback 28/09
    public void addFeedback(Feedback feedback) throws SQLException, Exception {
        String sql = "INSERT INTO Feedback (contentFeedback, ratings, editedTime, idShift, idUser) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getContentFeedback());
            ps.setInt(2, feedback.getRatings());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.MIN).valueOf(feedback.getEditedTime()));
            ps.setInt(4, feedback.getShift().getIdShift());
            ps.setInt(5, feedback.getUser().getIdUser());
            ps.executeUpdate();
        }
    }

    // Method to retrieve a Feedback by its ID
    public Feedback getFeedback(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM Feedback WHERE idFeedback = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Shifts shift = getShift(rs.getInt("idShift"));
                    User user = getUser(rs.getInt("idUser"));
                    return new Feedback(
                            rs.getInt("idFeedback"),
                            rs.getString("contentFeedback"),
                            rs.getInt("ratings"),
                            rs.getTimestamp("editedTime").toLocalDateTime(),
                            shift,
                            user
                    );
                }
            }
        }
        return null;
    }

    // Method to retrieve all Feedback entries
    public List<Feedback> getAllFeedbacks() throws SQLException, Exception {
        String sql = "SELECT * FROM Feedback";
        List<Feedback> feedbacks = new ArrayList<>();
        try (Connection connh = DBContext.getConnection(); PreparedStatement pss = connh.prepareStatement(sql)) {
             ResultSet rsH = pss.executeQuery();
            while (rsH.next()) {
                Shifts shift = getShift(rsH.getInt("idShift"));
                User user = getUser(rsH.getInt("idUser"));
                feedbacks.add(new Feedback(
                        rsH.getInt("idFeedback"),
                        rsH.getString("contentFeedback"),
                        rsH.getInt("ratings"),
                        rsH.getTimestamp("editedTime").toLocalDateTime(),
                        shift,
                        user
                ));
            }
        }System.out.println(feedbacks.toString());
        return feedbacks;
    }

    // Method to update a Feedback entry
    public void updateFeedback(Feedback feedback) throws SQLException, Exception {
        String sql = "UPDATE Feedback SET contentFeedback = ?, ratings = ?, editedTime = ?, idShift = ?, idUser = ? WHERE idFeedback = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getContentFeedback());
            ps.setInt(2, feedback.getRatings());
            ps.setTimestamp(3, Timestamp.valueOf(feedback.getEditedTime()));
            ps.setInt(4, feedback.getShift().getIdShift());
            ps.setInt(5, feedback.getUser().getIdUser());
            ps.setInt(6, feedback.getIdFeedback());
            ps.executeUpdate();
        }
    }

    // Method to delete a Feedback entry by its ID
    public void deleteFeedback(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Feedback WHERE idFeedback = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Feedback> getFeedbackByService(int idService) throws Exception {
        String sql = "SELECT \n"
                + "    f.idFeedback,\n"
                + "    f.contentFeedback,\n"
                + "    f.ratings,\n"
                + "    f.editedTime,\n"
                + "    s.idService\n"
                + "FROM \n"
                + "    Feedback f\n"
                + "JOIN \n"
                + "    Shifts sh ON f.idShift = sh.idShift\n"
                + "JOIN \n"
                + "    Service s ON sh.idShift = s.idService \n"
                + "WHERE \n"
                + "    idService = ?";
        List<Feedback> feedbacks = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idService);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Shifts shift = getShift(rs.getInt("idShift"));
                User user = getUser(rs.getInt("idUser"));
                feedbacks.add(new Feedback(
                        rs.getInt("idFeedback"),
                        rs.getString("contentFeedback"),
                        rs.getInt("ratings"),
                        rs.getTimestamp("editedTime").toLocalDateTime(),
                        shift,
                        user
                ));
            }
        }
        return feedbacks;
    }

    // service
    public void addService(Service service) throws SQLException, Exception {
        String sql = "INSERT INTO Service (nameService, description, img1, img2, img3, img4, img5, img6, idTypeService) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescription());
            stmt.setString(3, service.getImg1());
            stmt.setString(4, service.getImg2());
            stmt.setString(5, service.getImg3());
            stmt.setString(6, service.getImg4());
            stmt.setString(7, service.getImg5());
            stmt.setString(8, service.getImg6());
            stmt.setInt(9, service.getTypeService().getIdTypeService());

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
        String sql = "UPDATE Service SET nameService = ?, description = ?, img1 = ?, img2 = ?, img3 = ?, img4 = ?, img5 = ?, img6 = ?, idTypeService = ? WHERE idService = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescription());
            stmt.setString(3, service.getImg1());
            stmt.setString(4, service.getImg2());
            stmt.setString(5, service.getImg3());
            stmt.setString(6, service.getImg4());
            stmt.setString(7, service.getImg5());
            stmt.setString(8, service.getImg6());
            stmt.setInt(9, service.getTypeService().getIdTypeService());
            stmt.setInt(10, service.getIdService());
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
        service.setImg4(rs.getString("img4"));
        service.setImg5(rs.getString("img5"));
        service.setImg6(rs.getString("img6"));

        // Assuming you have a TypeServiceDAO to get TypeService by id
        TypeService typeService = getTypeService(rs.getInt("idTypeService"));
        service.setTypeService(typeService);
        return service;
    }

    // get typeservice
    public TypeService getTypeService(int idTypeService) throws SQLException, Exception {
        String sql = "SELECT * FROM TypeService WHERE idTypeService = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTypeService);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapTypeService(rs);
                }
            }
        }
        return null;
    }

    public List<TypeService> getAllTypeServices() throws SQLException, Exception {
        List<TypeService> typeServices = new ArrayList<>();
        String sql = "SELECT * FROM TypeService";
        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                typeServices.add(mapTypeService(rs));
            }
        }
        return typeServices;
    }

    private TypeService mapTypeService(ResultSet rs) throws SQLException {
        TypeService typeService = new TypeService();
        typeService.setIdTypeService(rs.getInt("idTypeService"));
        typeService.setNameTypeService(rs.getString("nameTypeService"));
        typeService.setColorTypeService(rs.getString("colorTypeService"));
        return typeService;
    }

    public Iterable<Service> getServiceBySearchContent(String search) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Iterable<Service> getServiceByCategory(String searchCategory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<User> getAllStaff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Order> getOrderByUserId(int idUser) throws Exception {
        String sql = "SELECT * FROM [Order] WHERE idUser = ?";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUser(rs.getInt("idUser"));
                List<Shifts> shifts = getAllShiftByOrder(rs.getInt("idOrder"));
                orders.add(new Order(rs.getInt("idOrder"), user, rs.getString("notes"), rs.getString("statusOrder"), ConvertConstant.convertDateToLocalDate(rs.getDate("dateCreate")), shifts));
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
    public DetailShifts getDetailShift(int idShift, int idUser, int idService) throws Exception {
        String sql = "SELECT * FROM DetailShift WHERE idShifts = ? AND idUser = ? AND idService = ?";
        DetailShifts detailShift = null;

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idShift);
            ps.setInt(2, idUser);
            ps.setInt(3, idService);

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
        String sql = "SELECT s.idService, s.nameService, s.description, s.img1, s.img2, s.img3, s.img4, s.img5, s.img6, idTypeService " +
                     "FROM DetailShift ds " +
                     "JOIN Service s ON ds.idService = s.idService " +
                     "WHERE ds.idShifts = ?";
        List<Service> services = new ArrayList<>();

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idShift);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TypeService typeService = getTypeService(rs.getInt("idTypeService"));
                Service service = new Service(
                    rs.getInt("idService"),
                    rs.getString("nameService"),
                    rs.getString("description"),
                    rs.getString("img1"),
                    rs.getString("img2"),
                    rs.getString("img3"),
                    rs.getString("img4"),
                    rs.getString("img5"),
                    rs.getString("img6"),
                        typeService
                );
                services.add(service); // Add the service to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }
    
}
