package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.Noticia;
import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.ArrayList;



public class LeitorArquivo {
	
	//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencv/
	
	protected ArrayList<Noticia> noticiasArquivo;
	
	public LeitorArquivo() {
		noticiasArquivo = new ArrayList<Noticia>();
	}
	
	public void readFile(String file) 
	{ 
	  
	    try { 
	  
	        FileReader filereader = new FileReader(file); 
	   
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	        
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	           Noticia temp = new Noticia();
	           temp.setHashCode(nextRecord[0]);
	           temp.setConteudo(nextRecord[1]);
	           temp.setUrl(nextRecord[2]);
	           //temp.setData(nextRecord[3]);
	           noticiasArquivo.add(temp);
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	
	public  ArrayList<Noticia> getListaFormatada(){
		return noticiasArquivo;
	}
}
