package com.g15.jpa.service;

import com.g15.jpa.entity.Message;
import com.g15.jpa.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
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

    public List<Message> getMessage() {
        return messageRepository.findAll();
    }

    public Message insertMessage(Message message) {
        return messageRepository.save(message);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).get();
    }
    
    //Metodo para eliminar (Capa de servicios)
    public void deleteMessage(Long id){
       messageRepository.deleteById(id);               
    }
    
    public Message updateMessage(Message message){
        //la farm existe
        if (message.getIdMessage()!=null){
            //validamos si la Reservation existe
            Optional<Message> opcional =  messageRepository.findById(message.getIdMessage());
            
            //la farm no existe
            if (opcional.isEmpty()) return message;
            //si la farm existe
            else{
               Message msgDB = opcional.get();
               
               if (message.getMessageText()!=null) msgDB.setMessageText(message.getMessageText());
               if (message.getClient()!=null) msgDB.setClient(message.getClient());
               if (message.getFarm()!=null) msgDB.setFarm(message.getFarm());
               
               return messageRepository.save(msgDB);
            }
            
        }
        return message;
    }
}
