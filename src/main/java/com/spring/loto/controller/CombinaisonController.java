package com.spring.loto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
