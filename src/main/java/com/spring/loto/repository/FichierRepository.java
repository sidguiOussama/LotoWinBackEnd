package com.spring.loto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loto.entities.Fichier;

@Repository
public interface FichierRepository  extends JpaRepository<Fichier,Integer>{

}
