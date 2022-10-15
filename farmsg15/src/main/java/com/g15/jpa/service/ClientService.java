package com.g15.jpa.service;

import com.g15.jpa.entity.Client;
import com.g15.jpa.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrollo
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }
    
    //Metodo para actualizar (Capa de servicios)
    public Client updateClient(Client client){
    //la farm existe
    if (client.getIdClient()!=null){
            //validamos si la farm existe
            Optional<Client> opcional =  clientRepository.findById(client.getIdClient());

            //la farm no existe
            if (opcional.isEmpty()) return client;
            //si la farm existe
            else{
               Client clientDB = opcional.get();

               if (client.getAge()!=null) clientDB.setAge(client.getAge());
               if (client.getEmail()!=null) clientDB.setEmail(client.getEmail());
               if (client.getName()!=null) clientDB.setName(client.getName());
               if (client.getPassword()!=null) clientDB.setPassword(client.getPassword());
               return clientRepository.save(clientDB);
            }

    }
    return client;
    }

    //Metodo para eliminar (Capa de servicios)
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
