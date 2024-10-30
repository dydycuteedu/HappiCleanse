/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private int idOrder;
    private User user;
    private User staff;

    private String notes;

    private String statusOrder;
    private LocalDateTime dateCreate;
    private LocalDateTime dateService;
    
    private Shifts shifts;

    public Order(int idOrder, User user, String notes, String statusOrder, LocalDateTime dateCreate,LocalDateTime dateService, Shifts shifts, User staff) {
        this.idOrder = idOrder;
        this.user = user;
        this.notes = notes;
        this.statusOrder = statusOrder;
        this.dateCreate = dateCreate;
        this.dateService = dateService;
        this.shifts = shifts;
        this.staff = staff;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateService() {
        return dateService;
    }

    public void setDateService(LocalDateTime dateService) {
        this.dateService = dateService;
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

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", user=" + user + ", notes=" + notes + ", statusOrder=" + statusOrder + ", dateCreate=" + dateCreate + ", shifts=" + shifts + '}';
    }
    
    
}
