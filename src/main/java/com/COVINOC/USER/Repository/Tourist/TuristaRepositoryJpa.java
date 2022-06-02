package com.COVINOC.USER.Repository.Tourist;

import com.COVINOC.USER.Models.Tourist.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristaRepositoryJpa extends JpaRepository<Turista,Integer> {
}
