
package model;

import java.time.LocalDateTime;



public class Chat {

    private int idChat;
    private User userSend;
    private LocalDateTime dateSend;

    public Chat(int idChat, User userSend, LocalDateTime dateSend) {
        this.idChat = idChat;
        this.userSend = userSend;
        this.dateSend = dateSend;
    }

    public Chat() {
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDateTime dateSend) {
        this.dateSend = dateSend;
    }

    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", userSend=" + userSend + ", dateSend=" + dateSend + '}';
    }

}
