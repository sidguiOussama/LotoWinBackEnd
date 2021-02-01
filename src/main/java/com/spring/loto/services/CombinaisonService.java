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

	////ggg
	private void combinationUtil(int arr[], int data[], int start, int end, int index, int r) 
	{ 

		if (index == r) 
		{ 
			for (int j=0; j<r; j++) 
				System.out.print(data[j]+" "); 
			System.out.println(""); 
			return; 
		} 
		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{ 
			data[index] = arr[i]; 
			combinationUtil(arr, data, i+1, end, index+1, r); 
		} 
	}  
	public void printCombination(int arr[], int n, int r) 
	{ 	
		int data[]=new int[r]; 
		combinationUtil(arr, data, 0, n-1, 0, r); 
	} 
	

}
