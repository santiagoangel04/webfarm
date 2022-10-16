package com.g15.jpa.service;

import com.g15.jpa.entity.Category;
import com.g15.jpa.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrollo
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    } 
   
    public Category insertCategory(Category category){
        return categoryRepository.save(category);
    }
    
    //Metodo para consultar una registo x su id (Capa de servicios)
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }
    
    //Metodo para eliminar (Capa de servicios)
    public void deleteCategory(Long id){
       categoryRepository.deleteById(id);               
    }
    
    //Metodo para actualizar (Capa de servicios)
    public Category updateCategory(Category category){
        
        if (category.getId()!=null){
            Optional <Category>opcional = categoryRepository.findById(category.getId());

            if (!opcional.isEmpty()){
                Category categoryDB = opcional.get();

                categoryDB.setName(category.getName());
                categoryDB.setDescription(category.getDescription());

                return categoryRepository.save(categoryDB);
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
}
