package br.ufrn.imd.visao;

import java.io.FileNotFoundException;

import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.controle.TratadorString;
import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args){
		
		//WebScraping web = new WebScraping("https://esporte.uol.com.br/futebol/ultimas-noticias/2019/05/27/cruzeiro-se-explica-de-denuncias-e-inquerito-policial-e-coisa-politica.htm");
	
		//web.load();
		
		//System.out.println(web.getTexto());
		
		LeitorArquivo leitor = new LeitorArquivo();
		leitor.readFile("boatos.csv");
		
		ArrayList<Noticia> lista = new ArrayList<Noticia>();
		
		lista = leitor.getListaNoticias();
		
		/*for(Noticia temp: lista) {
			System.out.println(temp.getCodigo());
			System.out.println(temp.getConteudo());
			System.out.println(temp.getUrl());
			System.out.println(temp.getData());
		}
		*/
		
		
		TratadorString trat = new TratadorString(lista.get(lista.size() - 1).getConteudo());
		
		String str = trat.filtro();
		
		System.out.println(str);
	}

}
