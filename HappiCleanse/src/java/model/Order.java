/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

public class Order {

    private int idOrder;
    private User user;
    private User staff;
    private Service service;
    private double totalMoney;

    private String notes;

    private String statusOrder;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;

    private Shifts shifts;
    private Feedback feedback;

    public Order(int idOrder, User user, Service service, String notes, String statusOrder, LocalDateTime timeStart, LocalDateTime timeEnd, Shifts shifts) {
        this.idOrder = idOrder;
        this.user = user;
        this.service = service;
        this.notes = notes;
        this.statusOrder = statusOrder;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.shifts = shifts;
    }

    public Order(int idOrder, User user, User staff, Service service, String notes, String statusOrder, LocalDateTime timeStart, LocalDateTime timeEnd, Shifts shifts) {
        this.idOrder = idOrder;
        this.user = user;
        this.staff = staff;
        this.service = service;
        this.notes = notes;
        this.statusOrder = statusOrder;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.shifts = shifts;
    }

    public Order(User user, Service service, String notes, String statusOrder, LocalDateTime timeStart) {
        this.user = user;
        this.service = service;
        this.notes = notes;
        this.statusOrder = statusOrder;
        this.timeStart = timeStart;
    }


    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Shifts getShifts() {
        return shifts;
    }

    public void setShifts(Shifts shifts) {
        this.shifts = shifts;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    
}
