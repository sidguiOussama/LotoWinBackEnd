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
	public int countTirageByCombinaisonBouleOneAndDateBetweenOrCombinaisonBouleTwoAndDateBetweenOrCombinaisonBouleThreeAndDateBetweenOrCombinaisonBouleFourAndDateBetweenOrCombinaisonBouleFiveAndDateBetween(int v1,Date d1, Date f1, int v2, Date d2, Date f2 ,int v3,Date d3, Date f3, int v4,Date d4, Date f4 ,int v5,Date d5, Date f5);
}
