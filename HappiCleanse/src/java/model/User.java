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

/**
 *
 * @author codevn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int idUser;

    private String nameUser;

    private String username;

    private String password;
    private String email;
    private String phonenumber;

    private String gender;
    private String avatar;
    
    private Address address;

    private int isValid;
    private int isCheck;

    private String role;
}
