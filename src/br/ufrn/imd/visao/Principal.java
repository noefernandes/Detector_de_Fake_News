package br.ufrn.imd.visao;

import java.io.FileNotFoundException;

import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		/*WebScraping web = new WebScraping("https://esporte.uol.com.br/futebol/ultimas-noticias/2019/05/27/cruzeiro-se-explica-de-denuncias-e-inquerito-policial-e-coisa-politica.htm");
	
		web.load();
		
		System.out.println(web.getTexto());
		*/
		
		
		LeitorArquivo leitor = new LeitorArquivo();
		leitor.load();
		
	}

}
