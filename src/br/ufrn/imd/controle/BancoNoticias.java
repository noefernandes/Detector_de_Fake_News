package br.ufrn.imd.controle;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.modelo.NoticiaTratada;
import br.ufrn.imd.modelo.NoticiaCSV;
import br.ufrn.imd.controle.TratadorString;

public class BancoNoticias {
	
	protected HashMap<String, Noticia> noticias;
	protected TratadorString trat;
	
	public BancoNoticias() {
		noticias = new HashMap<String, Noticia>();
		trat = new TratadorString();
	}
	
	public void addNoticia(String code, Noticia noticia) {
		noticias.put(code, noticia);
	}
	
	public void removeNoticia(String code){
		noticias.remove(code);
	}
	
	public void addListaDeNoticias(ArrayList<NoticiaCSV> lista) {
		
		for(NoticiaCSV n: lista) {
			NoticiaTratada temp = new NoticiaTratada();
			temp.setTexto(n.getTexto());
			temp.setTextoTratado(trat.filtrar(n.getTexto()));
			temp.setUrl(n.getUrl());
			temp.setData(n.getData());
			
			addNoticia(trat.toSHA1(temp.getTextoTratado()), temp);
		}
	}
	
	public void mostrarBanco() {
		for (Entry<String, Noticia> entry : noticias.entrySet()) {
		    System.out.println(		
		    						entry.getKey() + "\n" + 
		    						entry.getValue().getTexto() + "\n" +
		    						((NoticiaTratada) entry.getValue()).getTextoTratado() + "\n" +
		    						entry.getValue().getUrl() + "\n" +
		    						entry.getValue().getData()
		    				  );
		    System.out.println();
		}
	}
}
