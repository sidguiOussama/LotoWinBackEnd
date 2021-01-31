package com.spring.loto.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.loto.entities.Combinaison;
import com.spring.loto.repository.CombinaisonRepository;

@Service
public class CombinaisonService {

	@Autowired
	private CombinaisonRepository combinaisonRepository;
	
	public Combinaison saveCombinaison(Combinaison combinaison) {
		return combinaisonRepository.save(combinaison);
	}
	
	public void deleteCombinaison(Combinaison combinaison) {
		combinaisonRepository.delete(combinaison);
	}
	public void deleteCombinaisonById(Integer id) {
		combinaisonRepository.deleteById(id);
	}
	
	public List<Combinaison> findCombinaisons() {
		return combinaisonRepository.findAll();
	}
	
	public Optional<Combinaison> findCombinaisonById(Integer id) {
		return combinaisonRepository.findById(id);
	}
	
	/*Deprected*/
	public int countNumberBoule(int number) {
		return combinaisonRepository.countByBouleOneOrBouleTwoOrBouleThreeOrBouleFourOrBouleFive(number, number, number, number, number);
	}
}
