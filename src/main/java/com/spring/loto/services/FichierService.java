package com.spring.loto.services;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.util.StringUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.StandardCopyOption;


import com.spring.loto.entities.Fichier;
import com.spring.loto.entities.Tirage;
import com.spring.loto.repository.FichierRepository;


@Service
public class FichierService {

	public static final String FILE_DIRECTORY = "./src/main/resources/fichiers";
	public static final String IMPORT_FILE_DIRECTORY = "./src/main/resources/importFichier";
	public static final String EXPORT_FILE_DIRECTORY = "./src/main/resources/exportFichier";
	
	@Autowired
	private FichierRepository fichierRepository;
	
	@Autowired
	private static TirageService tirageService;
	
	
	public static void uploadFile(MultipartFile file, String directory) throws IOException {
		Path filePath = Paths.get(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}

	public StreamingResponseBody downloadFile(String filePath) throws IOException {
		File f = new File(filePath);
		InputStream inputStream = new FileInputStream(f);
		 return outputStream -> {
	            int nRead;
	            byte[] data = new byte[1024];
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                outputStream.write(data, 0, nRead);
	            }
	            inputStream.close();
	        };
	}
	
	public void removeFile(String file) throws IOException {
		Path filePath = Paths.get(file);
		Files.delete(filePath);
	}
	
	public Fichier saveFichier(Fichier fichier) {
		return fichierRepository.save(fichier);
	}
	
	public void deleteFichier(Fichier fichier) {
		fichierRepository.delete(fichier);
	}
	public void deleteFichierById(Integer id) {
		fichierRepository.deleteById(id);
	}
	
	public List<Fichier> findFichiers() {
		return fichierRepository.findAll();
	}
	
	public Optional<Fichier> findFichierById(Integer id) {
		return fichierRepository.findById(id);
	}
}
