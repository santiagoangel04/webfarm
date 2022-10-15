package com.g15.jpa.repository;

import com.g15.jpa.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author desaextremo
 */
public interface FarmRepository extends JpaRepository<Farm,Long> {
    
}
