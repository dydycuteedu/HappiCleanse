/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class User {

    private int idUser;

    private String fullname;

    private String username;

    private String password;
    private String email;
    private String phonenumber;

    private String gender;
    private String avatar;
    private String cvUrl;
    
    private String address;

    private int isValid;
    private int isCheck;

    private String role;

    public User(int idUser, String fullname, String username, String password, String email, String phonenumber, String gender, String avatar, String address, int isValid, int isCheck, String role,String CVURL) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.avatar = avatar;
        this.address = address;
        this.isValid = isValid;
        this.isCheck = isCheck;
        this.role = role;
        this.cvUrl = CVURL;
    }

    public User(int idUser, String fullname, String username, String password, String email, String phonenumber, String gender, String avatar, String cvUrl, String address, int isValid, int isCheck, String role) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.avatar = avatar;
        this.cvUrl = cvUrl;
        this.address = address;
        this.isValid = isValid;
        this.isCheck = isCheck;
        this.role = role;
    }
    

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }
    

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nameUser=" + fullname + ", username=" + username + ", password=" + password + ", email=" + email + ", phonenumber=" + phonenumber + ", gender=" + gender + ", avatar=" + avatar + ", address=" + address + ", isValid=" + isValid + ", isCheck=" + isCheck + ", role=" + role + '}';
    }
    
}
