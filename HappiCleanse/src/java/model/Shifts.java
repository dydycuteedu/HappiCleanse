/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Shifts {

    private int idShift;

    private TypeShift typeShift;

    private double price;

    public Shifts(int idShift, TypeShift typeShift, double price) {
        this.idShift = idShift;
        this.typeShift = typeShift;
        this.price = price;
    }

    
    public Shifts (TypeShift typeShift, double price) {
        this.typeShift = typeShift;
        this.price = price;
    }

    public Shifts() {
    }

    public int getIdShift() {
        return idShift;
    }

    public void setIdShift(int idShift) {
        this.idShift = idShift;
    }

    public TypeShift getTypeShift() {
        return typeShift;
    }

    public void setTypeShift(TypeShift typeShift) {
        this.typeShift = typeShift;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shifts{" + "idShift=" + idShift + ", typeShift=" + typeShift + ", price=" + price + '}';
    }
    
    
}
