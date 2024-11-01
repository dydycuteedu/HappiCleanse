/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Feedback {

    private int idFeedback;

    private String contentFeedback;

    private int ratings;

    private LocalDate editedTime;

    private Order order;

    private User user;

    public Feedback(int idFeedback, String contentFeedback, int ratings,Order order, User user) {
        this.idFeedback = idFeedback;
        this.contentFeedback = contentFeedback;
        this.ratings = ratings;
        this.order = order;
        this.user = user;
    }

    public Feedback() {
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getContentFeedback() {
        return contentFeedback;
    }

    public void setContentFeedback(String contentFeedback) {
        this.contentFeedback = contentFeedback;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public LocalDate getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(LocalDate editedTime) {
        this.editedTime = editedTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idFeedback=" + idFeedback + ", contentFeedback=" + contentFeedback + ", ratings=" + ratings + ", editedTime=" + editedTime + ", order=" + order + ", user=" + user + '}';
    }

    
}
