package com.COVINOC.USER.Repository.City;

import com.COVINOC.USER.Models.City.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepositoryJpa extends JpaRepository<Destino,Integer> {
}
