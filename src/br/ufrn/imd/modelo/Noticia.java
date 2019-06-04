package br.ufrn.imd.modelo;
//import java.util.Date;

public class Noticia {
	String codigo;
	String conteudo;
	String url;
	
	public String getCodigo() {
		return codigo;
	}
	public void setHashCode(String codigo) {
		this.codigo = codigo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
