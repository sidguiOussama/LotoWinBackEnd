package com.spring.loto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loto.dto.CombinDTO;
import com.spring.loto.entities.Combinaison;
import com.spring.loto.services.CombinaisonService;




@CrossOrigin("*")
@RequestMapping("/Combinaison")
@RestController
public class CombinaisonController {

	@Autowired
	private CombinaisonService combinaisonService;
	
	@PostMapping("/Add")
	public Combinaison addCombinaison(@RequestBody Combinaison combinaison) {
		return combinaisonService.saveCombinaison(combinaison);
	}
	
	@DeleteMapping("/Delete/{id}")
	public void deleteCombinaisonById(@PathVariable("id") int id) {
		combinaisonService.deleteCombinaisonById(id);
	}
	
	@GetMapping("/GetAll")
	public List<Combinaison> getAllCombinaisons(){
		return combinaisonService.findCombinaisons();
	}
	
	@GetMapping("/GetById/{id}")
	public  Optional<Combinaison> getCombinaisonById(@PathVariable("id") int id){
		return combinaisonService.findCombinaisonById(id);
	}
	
	/*@PostMapping("/AllCombin")
	public  HashMap<String, Integer> AllCombin(@RequestBody CombinDTO combinDTO){
		
		CombinDTO  dto = new CombinDTO(combinDTO.getValeurs(),combinDTO.getGarantie());
		HashMap<List<Integer>,String> s =combinaisonService.generateCombin(dto.getValeurs(),5);
		HashMap<List<Integer>,String> g =combinaisonService.generateCombin(dto.getValeurs(),dto.getGarantie());
		
		for (Map.Entry<List<Integer>, String> set : g.entrySet()) {
			
			for (Map.Entry<List<Integer>, String> set2 : s.entrySet()) {
				if(set2.getKey().containsAll(set.getKey())) {
					set.setValue(set2.getValue());
					break;
				}
			}
		}
		
		
		System.out.println(s);
		System.out.println(g);
		
		HashMap<String,Integer>hashMap = new HashMap<String, Integer>();
		for (Map.Entry<List<Integer>, String> set : g.entrySet()) {
			if(hashMap.get(set.getValue())==null) {
				hashMap.put(set.getValue(), 1);
			}else {
				hashMap.put(set.getValue(),hashMap.get(set.getValue())+1);
			}
		}
		
		System.out.println(hashMap);
		
		return hashMap;
		
	}*/
	
}
