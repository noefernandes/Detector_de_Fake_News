package br.ufrn.imd.controle;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraping {
	
	protected String titulo;
	protected String texto;
	protected String url;
	
	public WebScraping(String url) {
		this.url = url;
		titulo = "";
		texto = "";
	}
	
	public void setUrl(String url) { 
		this.url = url;
	}
	
	public String getTitle() {
		return titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void load() {			//Carrega a noticia, inicializando os campos da classe.
		
		try {
			Document doc = new Document("");
			doc = Jsoup.connect(url).get();
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
