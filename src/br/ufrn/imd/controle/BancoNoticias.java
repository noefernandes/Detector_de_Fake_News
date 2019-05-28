package br.ufrn.imd.controle;
import java.util.HashMap;
import br.ufrn.imd.modelo.Noticia;
//import br.ufrn.imd.modelo.NoticiaTratada;
//import br.ufrn.imd.modelo.NoticiaCSV;

public class BancoNoticias {
	
	HashMap<String, Noticia> noticias;
	
	public BancoNoticias() {
		noticias = new HashMap<String, Noticia>();
	}
	
	public void addNoticia(String code, Noticia noticia) {
		noticias.put(code, noticia);
	}
	
	public void removeNoticia(String code){
		noticias.remove(code);
	}
}
