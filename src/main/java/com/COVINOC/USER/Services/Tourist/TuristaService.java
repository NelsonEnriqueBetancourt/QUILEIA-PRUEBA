package com.COVINOC.USER.Services.Tourist;

import com.COVINOC.USER.Models.Tourist.Turista;
import com.COVINOC.USER.Repository.Tourist.TuristaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuristaService {

    @Autowired
    private TuristaRepositoryJpa repositoryJpa;


    public Turista getTuristaId(Integer id){
        return repositoryJpa.findById(id).get();
    }
}
