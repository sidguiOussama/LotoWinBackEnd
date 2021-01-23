package com.spring.loto.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.loto.entities.Fichier;
import com.spring.loto.entities.Tirage;
import com.spring.loto.services.StatistiqueService;

@CrossOrigin("*")
@RequestMapping("/Statistique")
@RestController
public class StatistiqueController {

	
	@Autowired
	private StatistiqueService statistiqueService;
	
	@GetMapping("/GetNumeroSouvent/{numero}")
	public  TreeMap<Integer, Integer> GetNumeroSouvent(@PathVariable("numero") int numero){
		TreeMap<Integer, Integer> map=  statistiqueService.numeroSouvent(numero);
		TreeMap<Integer, Integer> resultNumero = new TreeMap<Integer, Integer>();
		int counter = 0;
		for (Map.Entry<Integer, Integer>entry: map.entrySet() ) {
			if(counter >= (49-numero)) {
				resultNumero.put(entry.getKey(), entry.getValue());
			}
			counter++;
		}
		
		System.out.println("plus");
		System.err.println(resultNumero);
		return resultNumero;
	}
	
	@GetMapping("/GetNumeroMoinsSouvent/{numero}")
	public  TreeMap<Integer, Integer> GetNumeroMoinsSouvent(@PathVariable("numero") int numero){
		TreeMap<Integer, Integer> map=  statistiqueService.numeroSouvent(numero);
		TreeMap<Integer, Integer> resultNumero = new TreeMap<Integer, Integer>();
		int counter = 0;
		for (Map.Entry<Integer, Integer>entry: map.entrySet() ) {
			if(counter < numero) {
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
	
	@GetMapping("/SortieAnnee/{numero}")
	public  List<Tirage> SortieAnnee(@PathVariable("numero") int numero){
		System.out.println("haya");
		return statistiqueService.sortieSurAnnee(1, numero);
	}
}
