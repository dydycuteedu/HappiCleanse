/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class DetailShifts {

    private Shifts shifts;
    private User user;
    private Service service;

    public DetailShifts(Shifts shifts, User user, Service service) {
        this.shifts = shifts;
        this.user = user;
        this.service = service;
    }

    public DetailShifts() {
    }

    public Shifts getShifts() {
        return shifts;
    }

    public void setShifts(Shifts shifts) {
        this.shifts = shifts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "DetailShifts{" + "shifts=" + shifts + ", user=" + user + ", service=" + service + '}';
    }
    
}
