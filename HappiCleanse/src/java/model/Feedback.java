/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;


public class Feedback {

    private int idFeedback;

    private String contentFeedback;

    private int ratings;

    private LocalDateTime editedTime;

    private Shifts shift;

    private User user;

    public Feedback(int idFeedback, String contentFeedback, int ratings, LocalDateTime editedTime, Shifts shift, User user) {
        this.idFeedback = idFeedback;
        this.contentFeedback = contentFeedback;
        this.ratings = ratings;
        this.editedTime = editedTime;
        this.shift = shift;
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

    public LocalDateTime getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(LocalDateTime editedTime) {
        this.editedTime = editedTime;
    }

    public Shifts getShift() {
        return shift;
    }

    public void setShift(Shifts shift) {
        this.shift = shift;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idFeedback=" + idFeedback + ", contentFeedback=" + contentFeedback + ", ratings=" + ratings + ", editedTime=" + editedTime + ", shift=" + shift + ", user=" + user + '}';
    }

    
}
