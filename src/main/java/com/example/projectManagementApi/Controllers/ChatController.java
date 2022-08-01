package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IChat;
import com.example.projectManagementApi.Models.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chat")
@CrossOrigin(maxAge = 3600)
public class ChatController {
    @Autowired
    IChat iChat;

    @GetMapping("/{senderId}/{receiverId}")
    public List<Chat> getChats(@PathVariable String senderId, @PathVariable String receiverId){
         return iChat.getChat(senderId,receiverId);
    }

    @PostMapping("/save")
    public void save(@RequestBody Chat chat){
        iChat.save(chat);
    }
}
