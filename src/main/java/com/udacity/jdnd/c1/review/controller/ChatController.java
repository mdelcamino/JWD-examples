package com.udacity.jdnd.c1.review.controller;
import com.udacity.jdnd.c1.review.model.ChatForm;
import com.udacity.jdnd.c1.review.service.MessageService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute ("chatMessages", this.messageService.getMessage());
        return "chat";
    }

    @PostMapping("/chat")
    public String postChatMessage(ChatForm chatForm, Model model) {
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getMessage());
        return "chat";
    }
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
