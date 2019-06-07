package br.ufrn.imd.modelo;
//import java.util.Date;

public abstract class Noticia {
	
	protected String texto;
	protected String url;
	protected String data;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
