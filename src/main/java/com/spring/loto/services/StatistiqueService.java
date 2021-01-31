package com.spring.loto.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.persistence.metamodel.StaticMetamodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.loto.dto.TirageDTO;
import com.spring.loto.entities.Tirage;
import com.spring.loto.repository.TirageRepository;

@Service
public class StatistiqueService {

	@Autowired 
	CombinaisonService combinaisonService;
	
	@Autowired
	TirageService tirageService;
	
	@Autowired
	TirageRepository repository;
	
	public List<Tirage> sortieSurAnnee(int annee, int numero){
		List<Tirage>temp = new ArrayList<Tirage>();
		for(Tirage tirage:tirageService.getTiragesByBoule(numero) ) {
		
			Date date = tirage.getDate();
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			if(year == annee) {
				temp.add(tirage);
			}

		}
		return temp;
	}
	public  TreeMap<Integer, Integer> numeroSouvent(TirageDTO dto){
		TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>();
		/*DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Date debut=null,fin=null;
		try {
			debut = formatter.parse(dto.getDatedebut().toString());
			fin = formatter.parse(dto.getDateFin().toString());
		} catch (ParseException e) {
		}*/
		
		for(int i = 1 ; i<=49 ;i++ ) {
			int count  = tirageService.countNumberBoule(i,dto.getDatedebut(),dto.getDateFin());
			temp.put(i, count);
		}
		temp = (TreeMap<Integer, Integer>) valueSort(temp);
		return temp;
	}
	public static <K, V extends Comparable<V> > Map<K, V>  valueSort(final Map<K, V> map) 
    { 

        Comparator<K> valueComparator = new Comparator<K>() { 
             
                  public int compare(K k1, K k2) 
                  { 
                      int comp = map.get(k1).compareTo( 
                          map.get(k2)); 
                      if (comp == 0) 
                          return 1; 
                      else
                          return comp; 
                  } 
            
              }; 
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator); 
        
        sorted.putAll(map); 
        
        return sorted; 
    } 
}
