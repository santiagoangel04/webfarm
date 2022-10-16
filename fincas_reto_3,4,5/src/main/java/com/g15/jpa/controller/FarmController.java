package com.g15.jpa.controller;

import com.g15.jpa.entity.Farm;
import com.g15.jpa.service.FarmService;
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
@RequestMapping("/Farm")
@CrossOrigin(origins = "*")
public class FarmController {
    @Autowired
    private FarmService farmService;
    
    @GetMapping("/all")
    public List<Farm> getFarmList(){
        return farmService.getFarmList();
    }
    
    @GetMapping("/{id}")
    public Farm getFarmById(@PathVariable("id") Long id){
        return farmService.getFarmById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertFarm(@RequestBody Farm farm){
       farmService.insertFarm(farm);
       return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateFarm(@RequestBody Farm farm){
       farmService.updateFarm(farm);
       return ResponseEntity.status(201).build(); 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFarm(@PathVariable("id") Long id){
       farmService.deleteFarm(id);
       return ResponseEntity.status(204).build();
    }
}
