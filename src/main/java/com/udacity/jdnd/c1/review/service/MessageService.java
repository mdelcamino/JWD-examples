package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.model.ChatForm;
import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> chatMessage;
    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessage = new ArrayList<>();
    }

    public void addMessage(ChatForm chatform){
        ChatMessage newMessage= new ChatMessage(); //como si fuera la tabla de la bbdd
        newMessage.setUsername(chatform.getUsername());
        switch (chatform.getMessageType()) {
            case "Say" -> newMessage.setMessage(chatform.getMessageText());
            case "Shout" -> newMessage.setMessage(chatform.getMessageText().toUpperCase());
            case "Whisper" -> newMessage.setMessage(chatform.getMessageText().toLowerCase());
        }
           this.chatMessage.add(newMessage);
          }
    public List<ChatMessage> getMessage(){
        return chatMessage;
    }

}
