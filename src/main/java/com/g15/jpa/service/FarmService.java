package com.g15.jpa.service;

import com.g15.jpa.entity.Farm;
import com.g15.jpa.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desaextremo
 */
@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;
    
    public List<Farm> getFarmList(){
        return farmRepository.findAll();
    }
    
    public Farm getFarmById(Long id){
        return farmRepository.findById(id).get();
    }
    
    public Farm insertFarm(Farm finca){
        return farmRepository.save(finca);
    }
    
    public void deleteFarm(Long id){
       farmRepository.deleteById(id);               
    }
    
    public Farm updateFarm(Farm finca){
        //la finca existe
        if (finca.getId()!=null){
            //validamos si la finca existe
            Optional<Farm> opcional =  farmRepository.findById(finca.getId());
            
            //la finca no existe
            if (opcional.isEmpty()) return finca;
            //si la finca existe
            else{
               Farm fincaDB = opcional.get();
               
               fincaDB.setAddress(finca.getAddress());
               fincaDB.setExtension(finca.getExtension());
               fincaDB.setCategory(finca.getCategory());
               fincaDB.setName(finca.getName());
               fincaDB.setDescription(finca.getDescription());
               return farmRepository.save(fincaDB);
            }
            
        }
        return finca;
    }
}
