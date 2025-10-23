package com.CollageProject.collageDiscord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CollageProject.collageDiscord.model.Message;
import com.CollageProject.collageDiscord.services.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService ;

    
    // when the the user join broadcast it and save the name and message and all the following things in the database !! 

    
// - @MessageMapping("/chat.join") → receives join event from frontend (studentName only).
// - @SendTo("/topic/public") → broadcasts the message to all connected users.
// - Server sets type = JOIN and content = "X joined the chat!".
// - Saves message to MongoDB via chatService.
// - Returns saved message for real-time display.
// */


    // when join save and broadcast it !!! 
    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    public Message addUser (Message message){

        message.setType(Message.MessageType.JOIN);
        message.setContent(message.getStudentName() + "Joined the chat ");

        // now function to save the data into the database 
        Message savedMessage = chatService.saveMessage(message);
        System.out.println("User joined and data stored in the databaaase");

        return savedMessage ;

    }


    // joined user 
    // function for broadcasting and saving into the database brother !! 
    
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessge(Message message){

        // for mapping MESSAGETYPE  = chat 
        message.setType(Message.MessageType.CHAT);


        // now save it to the data base 
        Message savedMessage = chatService.saveMessage(message);
        System.out.println("Messge saved to the database !! "+ savedMessage.getStudentName()+" - "+savedMessage.getContent());

        return savedMessage ;
    }

    
    // method to get all the message from the data base !!! 
    
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return chatService.getAllMessages();
    }



    
}
