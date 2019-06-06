package br.ufrn.imd.visao;

import java.io.FileNotFoundException;

import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.controle.TratadorString;
import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args){
		
		//Criando leitor de arquivo.
		LeitorArquivo leitor = new LeitorArquivo();
		//Lendo arquivo a partir de caminho.
		leitor.readFile("boatos.csv");
		
		//Criando array de noticias.
		ArrayList<Noticia> lista = new ArrayList<Noticia>();
		
		//Recebendo array com as noticias (cada linha). 
		lista = leitor.getListaNoticias();
		
		//Criando tratador de string e pegando a última noticia para teste.
		TratadorString trat = new TratadorString(lista.get(lista.size() - 1).getConteudo());
		
		String str = trat.filtro();
		
		System.out.println(str);
	}

}
