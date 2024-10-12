/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.List;
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
public class BoxChat {
    private int idBoxChat;
    private User userCustomer;
    
    private List<Chat> chatList;
}
