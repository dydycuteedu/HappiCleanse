/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Shifts {

    private int idShift;

    private TypeShift typeShift;

    public Shifts(int idShift, TypeShift typeShift) {
        this.idShift = idShift;
        this.typeShift = typeShift;
    }

    
    public Shifts (TypeShift typeShift) {
        this.typeShift = typeShift;
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

}
