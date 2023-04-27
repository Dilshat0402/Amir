package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Message;
import com.amir.Diploma.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
    public List<Message> getMessageByUserId(Long userId){
        return messageRepository.findMessageByUserId(userId);
    }
}
