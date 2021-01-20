package com.spring.loto.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.spring.loto.entities.Tirage;
import com.spring.loto.repository.TirageRepository;

@Service
public class TirageService {

	@Autowired
	private TirageRepository tirageRepository;
	
	public void AddTirageFromFile(MultipartFile file, String directory) throws IOException {
		FileInputStream f = new FileInputStream(new File(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename())));
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		boolean isHeader = true;
		for (Row row : sheet) {
			if(isHeader) {
				isHeader = false;
			} else {
				Tirage tirage = new Tirage();
				tirage.setNumeroTirage((int)row.getCell(0).getNumericCellValue());
				tirage.setJour(row.getCell(1).getStringCellValue().toString());
				///all column
				saveTirage(tirage);
			}
		}
		workbook.close();
	}
	public Tirage saveTirage(Tirage tirage) {
		return tirageRepository.save(tirage);
	}
	
	public void deleteTirage(Tirage tirage) {
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
