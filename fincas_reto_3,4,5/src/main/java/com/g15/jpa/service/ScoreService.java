package com.g15.jpa.service;

import com.g15.jpa.entity.Score;
import com.g15.jpa.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desaextremo
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    //Metodo para consultar todos los registros (Capa de servicios)
    public List<Score> getScore() {
        return scoreRepository.findAll();
    }

    //Metodo para insertar (Capa de servicios)
    public Score insertScore(Score score) {
        return scoreRepository.save(score);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).get();
    }
}
