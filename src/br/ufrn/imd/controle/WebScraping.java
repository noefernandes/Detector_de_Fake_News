package br.ufrn.imd.controle;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraping {
	
	private static WebScraping instancia;
	protected String titulo;
	protected String texto;
	protected String url;
	
	private WebScraping() {
		titulo = "";
		texto = "";
	}
	
	public static WebScraping getInstancia() {
		if(instancia == null) {
			instancia = new WebScraping();
		}
		
		return instancia;
	}
	
	public void setUrl(String url) { 
		this.url = url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void load(String urlAtual) {			//Carrega a noticia, inicializando os campos da classe.
		
		try {
			url = urlAtual;
			Document doc = new Document("");
			doc = Jsoup.connect(urlAtual).get();
			this.titulo = doc.title();
			Elements element = doc.select("p");
			for (Element t : element) {
				this.texto += t.text() + "\n";
			}
		}catch(IOException e){
			e.getMessage();
		}
	}
}
