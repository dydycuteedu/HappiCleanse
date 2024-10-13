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



public class BoxChat {
    private int idBoxChat;
    private User userCustomer;
    
    private List<Chat> chatList;

    public BoxChat(int idBoxChat, User userCustomer, List<Chat> chatList) {
        this.idBoxChat = idBoxChat;
        this.userCustomer = userCustomer;
        this.chatList = chatList;
    }

    public BoxChat() {
    }

    public int getIdBoxChat() {
        return idBoxChat;
    }

    public void setIdBoxChat(int idBoxChat) {
        this.idBoxChat = idBoxChat;
    }

    public User getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(User userCustomer) {
        this.userCustomer = userCustomer;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public String toString() {
        return "BoxChat{" + "idBoxChat=" + idBoxChat + ", userCustomer=" + userCustomer + ", chatList=" + chatList + '}';
    }
    
}
