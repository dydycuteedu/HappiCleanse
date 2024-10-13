/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/*phan chia ca lam*/
public class TypeShift {

    private int idTypeShift;
    private String colorTypeShift;
    private double coefficient;

    public TypeShift(int idTypeShift, String colorTypeShift, double coefficient) {
        this.idTypeShift = idTypeShift;
        this.colorTypeShift = colorTypeShift;
        this.coefficient = coefficient;
    }

    public TypeShift() {
    }

    public int getIdTypeShift() {
        return idTypeShift;
    }

    public void setIdTypeShift(int idTypeShift) {
        this.idTypeShift = idTypeShift;
    }

    public String getColorTypeShift() {
        return colorTypeShift;
    }

    public void setColorTypeShift(String colorTypeShift) {
        this.colorTypeShift = colorTypeShift;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "TypeShift{" + "idTypeShift=" + idTypeShift + ", colorTypeShift=" + colorTypeShift + ", coefficient=" + coefficient + '}';
    }
    
}
