/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class Service {

    private int idService;
    private String nameService;
    private String description;
    private String img1;
    private String img2;
    private String img3;
    private ServiceCategory serviceCategory;

    public Service(int idService, String nameService, String description, String img1, String img2, String img3, ServiceCategory serviceCategory) {
        this.idService = idService;
        this.nameService = nameService;
        this.description = description;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.serviceCategory = serviceCategory;
    }

    public Service() {
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }  
}
