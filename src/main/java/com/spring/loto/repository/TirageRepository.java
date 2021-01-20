package com.spring.loto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loto.entities.Tirage;

@Repository
public interface TirageRepository extends JpaRepository<Tirage,Integer> {

}
