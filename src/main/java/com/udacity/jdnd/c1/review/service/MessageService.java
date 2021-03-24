package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.model.ChatForm;
import com.udacity.jdnd.c1.review.model.ChatMessage;
import com.udacity.jdnd.c1.review.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
           }

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatform){
        ChatMessage newMessage= new ChatMessage(); //como si fuera la tabla de la bbdd
        newMessage.setUsername(chatform.getUsername());
        switch (chatform.getMessageType()) {
            case "Say" -> newMessage.setMessageText(chatform.getMessageText());
            case "Shout" -> newMessage.setMessageText(chatform.getMessageText().toUpperCase());
            case "Whisper" -> newMessage.setMessageText(chatform.getMessageText().toLowerCase());
        }
           messageMapper.insert(newMessage);
    }
    public List<ChatMessage> getMessage(String username)
    {
        return  messageMapper.getAllMessages(username);


    }

}
