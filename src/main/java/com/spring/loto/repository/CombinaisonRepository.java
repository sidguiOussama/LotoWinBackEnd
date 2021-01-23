package com.spring.loto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loto.entities.Combinaison;

@Repository
public interface CombinaisonRepository extends JpaRepository<Combinaison,Integer> {
	public int countByBouleOneOrBouleTwoOrBouleThreeOrBouleFourOrBouleFive(int v1, int v2, int v3, int v4,int v5);
}
