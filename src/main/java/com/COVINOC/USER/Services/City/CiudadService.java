package com.COVINOC.USER.Services.City;

import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Repository.City.CiudadRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepositoryJpa repositoryJpa;


    public Destino getCityId(Integer id){
        return repositoryJpa.findById(id).get();
    }
}
