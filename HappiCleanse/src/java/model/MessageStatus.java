/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class MessageStatus {
    private int status;
    private String content;

    public MessageStatus(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public MessageStatus() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageStatus{" + "status=" + status + ", content=" + content + '}';
    }
    
    
}
