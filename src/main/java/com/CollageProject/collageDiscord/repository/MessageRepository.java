package com.CollageProject.collageDiscord.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.CollageProject.collageDiscord.model.Message;

public interface MessageRepository extends MongoRepository<Message , String> {

    // we are making the interface so we can implement the mongo functions such as save find find all and the other things !!! 

    // we are using this functions in the chatServices Bro !! 

    // making our first custom made query etch all messages from MongoDB and sort them by the timestamp field in ascending order.  
    // mongodb make query using the functions name !!!

    List<Message> findAllBYOrderBYTimestampAsc();
    
}
