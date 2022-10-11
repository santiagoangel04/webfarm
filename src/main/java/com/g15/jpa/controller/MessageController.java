package com.g15.jpa.controller;

import com.g15.jpa.entity.Message;
import com.g15.jpa.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessage() {
        return messageService.getMessage();
    }
    
    @PostMapping("/save")
    public ResponseEntity insertMessage(@RequestBody Message message) {
        messageService.insertMessage(message);
        return ResponseEntity.status(201).build();
    }
}
