/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class DetailShifts {

    private TypeShift typeshifts;
    private User user;
    private Service service;

    public DetailShifts(TypeShift typeshifts, User user, Service service) {
        this.typeshifts = typeshifts;
        this.user = user;
        this.service = service;
    }

    public DetailShifts() {
    }

    public TypeShift getTypeshifts() {
        return typeshifts;
    }

    public void setTypeshifts(TypeShift typeshifts) {
        this.typeshifts = typeshifts;
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
    
}
