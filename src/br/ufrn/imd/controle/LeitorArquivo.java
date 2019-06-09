package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.NoticiaCSV;
import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.util.ArrayList;

import java.util.List;

public class LeitorArquivo {
	
	//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencv/
	protected ArrayList<NoticiaCSV> listaNoticias;
	private static LeitorArquivo instancia;
	
	private LeitorArquivo() {
		listaNoticias = new ArrayList<NoticiaCSV>();
	}
	
	public static LeitorArquivo getInstancia() {
		if(instancia == null) {
			instancia = new LeitorArquivo();
		}
		
		return instancia;
	}
	
	public void readFile(String file){ 
	  
		try { 
	      
	        FileReader filereader = new FileReader(file); 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	        
	        // Colocando os objetos NoticiaCSV para o ArrayList. 
	        for (String[] row : allData) { 
	        	NoticiaCSV temp = new NoticiaCSV();
	        	temp.setTexto(row[1]);
	        	temp.setUrl(row[2]);
	        	temp.setData(row[3]);
	        	
	        	listaNoticias.add(temp);
	        } 
	    } 
	    catch (Exception e) { 		//Criar nova exceção
	        e.printStackTrace(); 
	    } 
	}
	
	public ArrayList<NoticiaCSV> getListaNoticias(){
		return listaNoticias;
	}
}
