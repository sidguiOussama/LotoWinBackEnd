package com.spring.loto.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;

import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;
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

	
	public HashMap<List<Integer>,String> generateCombin(List<Integer>integers,int r){
		
		int value = 1;
		HashMap<List<Integer>,String> temp = new HashMap<List<Integer>, String>();
		IGenerator<List<Integer>>list = Generator.combination(integers).simple(r);
		for (List<Integer> list2 : list) {
			temp.put(list2,""+value);
			value++;
		}
		return temp;
	}
	

	 public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
	    { 
	        
	        List<Map.Entry<String, Integer> > list = 
	               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
	   
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> o1,  
	                               Map.Entry<String, Integer> o2) 
	            { 
	                return (o2.getValue()).compareTo(o1.getValue()); 
	            } 
	        });   
	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
	        for (Map.Entry<String, Integer> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	    } 
	 
	 public Combinaison createCombinaison(List<Integer>integers) {
		 Combinaison combinaison = new Combinaison(integers.get(0),integers.get(1),integers.get(2),integers.get(3),integers.get(4),5);
		 return combinaison;
	 }
	 
	 public Combinaison findCombinByValue(String value ,HashMap<List<Integer>,String> hashMap) {
		 
		 for (Map.Entry<List<Integer>,String> aa : hashMap.entrySet()) { 
	            if(aa.getValue().equals(value)) {
	            	//
	            	//System.err.println(aa.getKey());
	            	return createCombinaison(aa.getKey());
	            }
	        } 
		 return null;
	 }
}
