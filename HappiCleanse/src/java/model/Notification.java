/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Notification {
    private int idNotification;

    private User user;

    private String content;

    public Notification(int idNotification, User user, String content) {
        this.idNotification = idNotification;
        this.user = user;
        this.content = content;
    }

    public Notification() {
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notification{" + "idNotification=" + idNotification + ", user=" + user + ", content=" + content + '}';
    }
    
    
}
