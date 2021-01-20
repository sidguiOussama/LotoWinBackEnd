package com.spring.loto.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.loto.entities.Fichier;
import com.spring.loto.services.FichierService;
import com.spring.loto.services.TirageService;


@CrossOrigin("*")
@RequestMapping("/Fichier")
@RestController
public class FichierController {

	@Autowired
	private FichierService fichierService;
	
	@Autowired
	private TirageService tirageService;
	
	@PostMapping("/Add")
	public Fichier addFichier(@RequestBody Fichier fichier) {
		return fichierService.saveFichier(fichier);
	}
	
	@DeleteMapping("/Delete/{id}")
	public void deleteFichierById(@PathVariable("id") int id) {
		fichierService.deleteFichierById(id);
	}
	
	@GetMapping("/GetAll")
	public List<Fichier> getAllFichiers(){
		return fichierService.findFichiers();
	}
	
	@GetMapping("/GetById/{id}")
	public  Optional<Fichier> getFichierById(@PathVariable("id") int id){
		return fichierService.findFichierById(id);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
		FichierService.uploadFile(file, FichierService.FILE_DIRECTORY);
		//apache poi
		tirageService.AddTirageFromFile(file,FichierService.FILE_DIRECTORY);
		System.out.println("haallaa");
		return new ResponseEntity<>("File has been uploaded && stored!", HttpStatus.OK);
	}
}
