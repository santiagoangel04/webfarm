package com.g15.jpa.controller;

//import com.g15.jpa.entity.Category;
import com.g15.jpa.entity.Client;
import com.g15.jpa.service.ClientService;
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
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getCategory(){
        return clientService.getClient();
    }  
    
    @PostMapping("/save")
    public ResponseEntity insertClient(@RequestBody Client client){
        clientService.insertClient(client);
        return ResponseEntity.status(201).build();
    }
}
