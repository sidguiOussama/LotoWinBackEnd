package com.spring.loto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loto.dto.CombinDTO;
import com.spring.loto.dto.EcartDTO;
import com.spring.loto.dto.TirageDTO;
import com.spring.loto.entities.Combinaison;
import com.spring.loto.entities.Fichier;
import com.spring.loto.entities.Tirage;
import com.spring.loto.services.CombinaisonService;
import com.spring.loto.services.StatistiqueService;

import io.swagger.models.auth.In;

@CrossOrigin("*")
@RequestMapping("/Statistique")
@RestController
public class StatistiqueController {

	
	@Autowired
	private StatistiqueService statistiqueService;
	
	
	@Autowired
	private CombinaisonService combinaisonService;
	
	@PostMapping("/GetNumeroSouvent")
	public  TreeMap<Integer, Integer> GetNumeroSouvent(@RequestBody TirageDTO tirageDTO){
		TreeMap<Integer, Integer> map=  statistiqueService.numeroSouvent(tirageDTO);
		TreeMap<Integer, Integer> resultNumero = new TreeMap<Integer, Integer>();
		int counter = 0;
		for (Map.Entry<Integer, Integer>entry: map.entrySet() ) {
			if(counter >= (49-tirageDTO.getNombre())) {
				resultNumero.put(entry.getKey(), entry.getValue());
			}
			counter++;
		}
		
		System.out.println("plus");
		System.err.println(resultNumero);
		return resultNumero;
	}
	
	@PostMapping("/GetNumeroMoinsSouvent")
	public  TreeMap<Integer, Integer> GetNumeroMoinsSouvent(@RequestBody TirageDTO tirageDTO){
		TreeMap<Integer, Integer> map=  statistiqueService.numeroSouvent(tirageDTO);
		TreeMap<Integer, Integer> resultNumero = new TreeMap<Integer, Integer>();
		int counter = 0;
		for (Map.Entry<Integer, Integer>entry: map.entrySet() ) {
			if(counter < tirageDTO.getNombre()) {
				resultNumero.put(entry.getKey(), entry.getValue());
				counter++;
			}else {
				break;
			}
		}
		System.out.println("moins");
		System.err.println(resultNumero);
		return resultNumero;
	}
	
	@GetMapping("/SortieAnnee/{numero}/{annee}")
	public  List<Tirage> SortieAnnee(@PathVariable("numero") int numero,@PathVariable("annee") int annee){
		return statistiqueService.sortieSurAnnee(annee, numero);
	}
	
	@GetMapping("/EcartMinMax")
	public  List<EcartDTO> EcartMinMax(){
		List<EcartDTO>ecarts = new ArrayList<EcartDTO>();
		for(int i= 1; i<=49;i++) {
			ecarts.add(statistiqueService.ecart(i));
		}
		return ecarts;
	}
	
	@PostMapping("/AllCombin")
	public  List<Combinaison> AllCombin(@RequestBody CombinDTO combinDTO){
		
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
		
		
		System.err.println("sorted");
		//System.out.println(combinaisonService.sortByValue(hashMap));
		
		hashMap = combinaisonService.sortByValue(hashMap);
		System.out.println(hashMap);
		
		
		List<Combinaison>combinaisons = new ArrayList<Combinaison>();
		HashMap<String,Integer> maxHash = new HashMap<String, Integer>();
		int pred=0;
		for (Map.Entry<String, Integer> set : hashMap.entrySet()) {
			
			if(pred<g.size()/2) {
				maxHash.put(set.getKey(), set.getValue());
				pred = pred + set.getValue();
				combinaisons.add(combinaisonService.findCombinByValue(set.getKey(), s));
			}
			
		}

		return combinaisons;
		
	}
	

}
