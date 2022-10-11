package com.g15.jpa.controller;

import com.g15.jpa.entity.Category;
import com.g15.jpa.entity.Farm;
import com.g15.jpa.service.CategoryService;
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
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }
    
    @PostMapping("/save")
    public ResponseEntity insertCategory(@RequestBody Category categoria){
       categoryService.insertCategory(categoria);
       return ResponseEntity.status(201).build();
    }
}
