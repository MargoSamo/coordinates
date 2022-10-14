package com.mariia.coordinates.service;

import com.mariia.coordinates.model.FactValue;
import com.mariia.coordinates.repository.FactValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactValueService {

    private final FactValueRepository factValueRepository;

    @Autowired
    public FactValueService(FactValueRepository factValueRepository) {
        this.factValueRepository = factValueRepository;
    }

    public FactValue findById(Long id){
        return factValueRepository.getReferenceById(id);
    }

    public List<FactValue> findAll(){
        return factValueRepository.findAll();
    }

    public FactValue saveFactValue(FactValue factValues){
        return factValueRepository.save(factValues);
    }

    public void deleteById(Long id){
        factValueRepository.deleteById(id);
    }
}
