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

    private String notes;

    private String statusOrder;
    private LocalDateTime dateCreate;
    
    private List<Shifts> shifts;

    public Order(int idOrder, User user, String notes, String statusOrder, LocalDateTime dateCreate, List<Shifts> shifts) {
        this.idOrder = idOrder;
        this.user = user;
        this.notes = notes;
        this.statusOrder = statusOrder;
        this.dateCreate = dateCreate;
        this.shifts = shifts;
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

    public List<Shifts> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shifts> shifts) {
        this.shifts = shifts;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", user=" + user + ", notes=" + notes + ", statusOrder=" + statusOrder + ", dateCreate=" + dateCreate + ", shifts=" + shifts + '}';
    }
    
    
}
