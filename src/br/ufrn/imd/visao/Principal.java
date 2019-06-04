package br.ufrn.imd.visao;

import java.io.FileNotFoundException;

import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException{
		
		//WebScraping web = new WebScraping("https://esporte.uol.com.br/futebol/ultimas-noticias/2019/05/27/cruzeiro-se-explica-de-denuncias-e-inquerito-policial-e-coisa-politica.htm");
	
		//web.load();
		
		//System.out.println(web.getTexto());
		
		LeitorArquivo leitor = new LeitorArquivo();
		leitor.readFile("boatos.csv");
		
	
		
		ArrayList<Noticia> lista = new ArrayList<Noticia>();
		lista = leitor.getListaFormatada();
		
		for(Noticia campo: lista) {
			System.out.println(campo.getCodigo());
			System.out.println(campo.getConteudo());
			System.out.println(campo.getUrl());
		}
	}

}
