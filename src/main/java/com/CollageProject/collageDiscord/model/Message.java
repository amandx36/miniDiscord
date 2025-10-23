package com.CollageProject.collageDiscord.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

@Document(collection = "messages") // this for the mongodb
public class Message {

    @Id // act as a primary key
    private String id;
    private String studentName;
    private String content;
    private LocalDateTime timestamp;
    private MessageType type;

    // enum = special type of variable for which has predefined consant unchangable
    public enum MessageType {
        JOIN, CHAT, LEAVE
    }

    // Constructor
    public Message() {

    }

    public Message(String studentName, String content, MessageType type) {
        this.studentName = studentName;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    // Getters and Setters 

    // to set the value and to get the value !!!
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

}