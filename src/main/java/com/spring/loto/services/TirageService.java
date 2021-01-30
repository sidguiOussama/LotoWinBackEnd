package com.spring.loto.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.loto.entities.Combinaison;
import com.spring.loto.entities.Fichier;
import com.spring.loto.entities.Tirage;
import com.spring.loto.repository.TirageRepository;

@Service
public class TirageService {

	@Autowired
	private TirageRepository tirageRepository;
	
	@Autowired
	private CombinaisonService combinaisonService;
	 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public void AddTirageFromFile(MultipartFile file, String directory) throws IOException {
		FileInputStream f = new FileInputStream(new File(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename())));
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		boolean isHeader = true;
		for (Row row : sheet) {
			if(isHeader) {
				isHeader = false;
			} else {
				
				int numero = (int)row.getCell(0).getNumericCellValue();
				if(!tirageExist(numero)) {
					Tirage tirage = new Tirage();
					tirage.setNumeroTirage((int)row.getCell(0).getNumericCellValue());
					tirage.setJour(row.getCell(1).getStringCellValue().toString());
					tirage.setDate(row.getCell(2).getDateCellValue());
					
					//Combinaison
					Combinaison combinaison = new Combinaison();
					combinaison.setBouleOne((int)row.getCell(4).getNumericCellValue());
					combinaison.setBouleTwo((int)row.getCell(5).getNumericCellValue());
					combinaison.setBouleThree((int)row.getCell(6).getNumericCellValue());
					combinaison.setBouleFour((int)row.getCell(7).getNumericCellValue());
					combinaison.setBouleFive((int)row.getCell(8).getNumericCellValue());
					combinaison.setNumeroChance((int)row.getCell(9).getNumericCellValue());
					combinaison = combinaisonService.saveCombinaison(combinaison);
					tirage.setCombinaison(combinaison);
					saveTirage(tirage);
				}else {
					workbook.close();
					return;
				}
			}
		}
		workbook.close();
	}
	
	public List<Tirage> getTiragesByBoule(int numero){
		return tirageRepository.findTirageByCombinaisonBouleOneOrCombinaisonBouleTwoOrCombinaisonBouleThreeOrCombinaisonBouleFourOrCombinaisonBouleFive(numero, numero, numero, numero, numero);
	}
	
	public boolean tirageExist(int numero) {
		Tirage tirage = tirageRepository.findByNumeroTirage(numero);
		if(tirage!=null) return true;
		return false;
	}
	public Tirage saveTirage(Tirage tirage) {
		return tirageRepository.save(tirage);
	}
	
	public void deleteTirage(Tirage tirage) {
		//details avant 
		tirageRepository.delete(tirage);
	}
	public void deleteTirageById(Integer id) {
		tirageRepository.deleteById(id);
	}
	
	public List<Tirage> findTirages() {
		return tirageRepository.findAll();
	}
	
	public Optional<Tirage> findTirageById(Integer id) {
		return tirageRepository.findById(id);
	}
	
}
