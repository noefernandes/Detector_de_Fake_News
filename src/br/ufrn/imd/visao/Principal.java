package br.ufrn.imd.visao;

import java.io.FileNotFoundException;

import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.controle.TratadorString;
import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import br.ufrn.imd.controle.ComparadorString;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args){
		
		//Criando leitor de arquivo.
		LeitorArquivo leitor = new LeitorArquivo();
		
		//Lendo arquivo a partir de caminho.
		leitor.readFile("boatos.csv");
		
		
		
	}

}
