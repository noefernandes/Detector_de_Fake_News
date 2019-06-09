package br.ufrn.imd.controle;

import java.util.Map.Entry;

import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.modelo.NoticiaTratada;

public class ComparadorNoticias {
	TratadorString trat;
	ComparadorString comp;
	BancoNoticias bn;
	String texto;
	
	public ComparadorNoticias(String texto) {
		trat = TratadorString.getInstancia();
		comp = ComparadorString.getInstancia();
		bn = BancoNoticias.getInstancia();
		this.texto = texto;
	}
	
	public boolean isFakeNews(double limite) {
		String noticia = trat.filtrar(texto);
		
		for (Entry<String, Noticia> entry : bn.getNoticiasDoBanco().entrySet()) {
			if(comp.distanciaLevenshtein(noticia, ((NoticiaTratada) entry.getValue()).getTextoTratado()) >= limite){
				System.out.println(((NoticiaTratada) entry.getValue()).getTexto());
				return true;
			}
		}
		return false;
	}
}
