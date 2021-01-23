package com.spring.loto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loto.entities.Tirage;

@Repository
public interface TirageRepository extends JpaRepository<Tirage,Integer> {

	public Tirage findByNumeroTirage(int numero);
	public List<Tirage> findTirageByCombinaisonBouleOneOrCombinaisonBouleTwoOrCombinaisonBouleThreeOrCombinaisonBouleFourOrCombinaisonBouleFive(int v1, int v2 ,int v3, int v4 ,int v5);
}
