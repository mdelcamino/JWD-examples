package com.udacity.jdnd.c1.review.model;

public class ChatMessage {
    private String messageid;
    private String username;
    private String messageText;

    public ChatMessage() {}

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }
}
