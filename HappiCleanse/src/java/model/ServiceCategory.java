/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ServiceCategory {
//phan loai service

    private int idServiceCategory;
    private String nameServiceCategory;
    private String colorServiceCategory;
    private String img;

    public ServiceCategory() {
    }

    public ServiceCategory(int idServiceCategory, String nameServiceCategory, String colorServiceCategory,String img) {
        this.idServiceCategory = idServiceCategory;
        this.nameServiceCategory = nameServiceCategory;
        this.colorServiceCategory = colorServiceCategory;
        this.img = img;
    }

    public int getIdServiceCategory() {
        return idServiceCategory;
    }

    public void setIdServiceCategory(int idServiceCategory) {
        this.idServiceCategory = idServiceCategory;
    }

    public String getNameServiceCategory() {
        return nameServiceCategory;
    }

    public void setNameServiceCategory(String nameServiceCategory) {
        this.nameServiceCategory = nameServiceCategory;
    }

    public String getColorServiceCategory() {
        return colorServiceCategory;
    }

    public void setColorServiceCategory(String colorServiceCategory) {
        this.colorServiceCategory = colorServiceCategory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    @Override
    public String toString() {
        return "ServiceCategory{" + "idServiceCategory=" + idServiceCategory + ", nameServiceCategory=" + nameServiceCategory + ", colorServiceCategory=" + colorServiceCategory + '}';
    }

}
