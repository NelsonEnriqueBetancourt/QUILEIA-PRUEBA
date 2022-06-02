package com.COVINOC.USER.Repository.Tourist;

import com.COVINOC.USER.Models.Tourist.Turista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TuristaRepository extends CrudRepository<Turista,Integer> {

    Collection<Turista>findAll();
}
