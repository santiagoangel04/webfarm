package com.g15.jpa.service;

import com.g15.jpa.entity.Message;
import com.g15.jpa.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desaextremo
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getMessage(){
	return messageRepository.findAll();
    }
    
    public Message insertMessage(Message message){
	return messageRepository.save(message);
    }
}
