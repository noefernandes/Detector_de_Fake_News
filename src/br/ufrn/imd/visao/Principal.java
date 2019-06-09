package br.ufrn.imd.visao;

import br.ufrn.imd.controle.LeitorArquivo;
import br.ufrn.imd.controle.WebScraping;
import br.ufrn.imd.controle.BancoNoticias;
import br.ufrn.imd.controle.ComparadorNoticias;


public class Principal {

	public static void main(String[] args){
		
		//Criando leitor de arquivo.
		LeitorArquivo leitor = LeitorArquivo.getInstancia();
		
		//Lendo arquivo a partir de caminho.
		leitor.readFile("boatos.csv");
		
		//Criando um banco de noticias e adicionando noticias processadas do csv.
		BancoNoticias bn = BancoNoticias.getInstancia();
		bn.addListaDeNoticias(leitor.getListaNoticias());
		
		//Criando uma classe de webscraping e carregando uma noticia.
		WebScraping web = WebScraping.getInstancia(); 
		web.load("http://www.ceilandiaemalerta.com.br/2018/05/25/pauta-dos-caminhoneiros-tambem-responsabiliza-este-causo-ao-governo-de-goias/");
		
		//Comparando a noticia da internet com as noticias processadas do banco.
		//Se a similaridade for maior do que o limite atribuido, é Fake news.
		ComparadorNoticias comp = new ComparadorNoticias(web.getTexto());
		
		if(comp.isFakeNews(50.0)) {
			System.out.println("É fake news!");
		}else {
			System.out.println("Não é fake news!");
		}
		
	}

}
