/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ServiceCategory {
//phan loai service

    private int idServiceCategory;
    private String nameServiceCategory;

    private String imgURL;

    public ServiceCategory() {
    }

    public ServiceCategory(int idServiceCategory, String nameServiceCategory, String imgURL) {
        this.idServiceCategory = idServiceCategory;
        this.nameServiceCategory = nameServiceCategory;

        this.imgURL = imgURL;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "ServiceCategory{" + "idServiceCategory=" + idServiceCategory + ", nameServiceCategory=" + nameServiceCategory + ", imgURL=" + imgURL + '}';
    }

}
