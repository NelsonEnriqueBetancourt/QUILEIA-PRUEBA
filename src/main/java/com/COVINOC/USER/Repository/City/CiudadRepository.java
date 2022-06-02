package com.COVINOC.USER.Repository.City;

import com.COVINOC.USER.Models.City.Destino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface CiudadRepository extends CrudRepository<Destino,Integer> {

    Collection<Destino>findAll();
}
