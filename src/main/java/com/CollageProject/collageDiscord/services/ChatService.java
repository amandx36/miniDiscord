package com.CollageProject.collageDiscord.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollageProject.collageDiscord.model.Message;
import com.CollageProject.collageDiscord.repository.MessageRepository;



@Service
public class ChatService {
    
    @Autowired
    // this for dependicies injections !!!

    // completing the interface we made in the mongodb repository !! 
    private MessageRepository messageRepository ;


    // extending the custom method to save the data and add console printing for debug !!

    public Message saveMessage  (Message message){
        System.out.println("Message is being saved to the mongodb database !!! " + message.getStudentName() + "-- "+message.getContent());
        return messageRepository.save(message);
    }


    // making custom method to get all the message 

    public List<Message> getAllMessages() {
        return messageRepository.findAllByOrderByTimestampAsc();
    }

}
