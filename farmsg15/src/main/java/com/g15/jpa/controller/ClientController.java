package com.g15.jpa.controller;

import com.g15.jpa.entity.Client;
import com.g15.jpa.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getCategory() {
        return clientService.getClient();
    }

    @PostMapping("/save")
    public ResponseEntity insertClient(@RequestBody Client client) {
        clientService.insertClient(client);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }
    
    //Metodo para actualizar (Capa de controlador)
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client Client){
       clientService.updateClient(Client);
       return ResponseEntity.status(201).build(); 
    }
    
    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
       clientService.deleteClient(id);
       return ResponseEntity.status(204).build();
    }
}
