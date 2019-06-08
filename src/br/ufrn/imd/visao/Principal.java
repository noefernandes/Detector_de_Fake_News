package br.ufrn.imd.visao;

import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import br.ufrn.imd.controle.BancoNoticias;


public class Principal {

	public static void main(String[] args){
		
		//Criando leitor de arquivo.
		LeitorArquivo leitor = LeitorArquivo.getInstancia();
		
		//Lendo arquivo a partir de caminho.
		leitor.readFile("boatos.csv");
		
		BancoNoticias bn = BancoNoticias.getInstancia();
		
		bn.addListaDeNoticias(leitor.getListaNoticias());
		
		bn.mostrarBanco();
			
	}

}
