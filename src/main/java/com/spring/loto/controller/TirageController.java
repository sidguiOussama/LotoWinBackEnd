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

import com.spring.loto.entities.Tirage;

import com.spring.loto.services.TirageService;


@CrossOrigin("*")
@RequestMapping("/Tirage")
@RestController
public class TirageController {

	@Autowired
	private TirageService tirageService;
	
	@PostMapping("/Add")
	public Tirage addTirage(@RequestBody Tirage tirage) {
		return tirageService.saveTirage(tirage);
	}
	
	@DeleteMapping("/Delete/{id}")
	public void deleteTirageById(@PathVariable("id") int id) {
		tirageService.deleteTirageById(id);
	}
	
	@GetMapping("/GetAll")
	public List<Tirage> getAllTirages(){
		return tirageService.findTirages();
	}
	
	@GetMapping("/GetById/{id}")
	public  Optional<Tirage> getTirageById(@PathVariable("id") int id){
		return tirageService.findTirageById(id);
	}
	
}
