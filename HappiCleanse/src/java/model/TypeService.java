/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class TypeService {
//phan loai service
    private int idTypeService;
    private String nameTypeService;
    private String colorTypeService;

    public TypeService(int idTypeService, String nameTypeService, String colorTypeService) {
        this.idTypeService = idTypeService;
        this.nameTypeService = nameTypeService;
        this.colorTypeService = colorTypeService;
    }

    public TypeService() {
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameTypeService() {
        return nameTypeService;
    }

    public void setNameTypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }

    public String getColorTypeService() {
        return colorTypeService;
    }

    public void setColorTypeService(String colorTypeService) {
        this.colorTypeService = colorTypeService;
    }

    @Override
    public String toString() {
        return "TypeService{" + "idTypeService=" + idTypeService + ", nameTypeService=" + nameTypeService + ", colorTypeService=" + colorTypeService + '}';
    }

}
