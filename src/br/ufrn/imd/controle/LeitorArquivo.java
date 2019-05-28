package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeitorArquivo {
	
	protected ArrayList<String> linhas;
	
	public LeitorArquivo() {
		linhas = new ArrayList<String>();
	}
	
	public void load() throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader("boatos.csv"));
	    
	    scanner.useDelimiter(";");
	    
	    int count = 0;
	
	    while (scanner.hasNext())
	    {
	    	//System.out.println(scanner.next());
	    	count = count + 1 ;
	    }
	     
	    System.out.println("value:" + count);
	    scanner.close();
	    
	}
}
