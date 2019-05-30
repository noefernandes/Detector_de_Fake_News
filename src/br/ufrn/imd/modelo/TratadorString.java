package br.ufrn.imd.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class TratadorString {
	protected String noticia;
	
	public TratadorString(String s_) {
		noticia = s_;
	}

	public String filtro() {
		noticia = noticia.replaceAll("[\\.$|,|;|']", "");
		noticia = noticia.replaceAll("[ãáà]", "a");
		noticia = noticia.replaceAll("[õó]","o" );
		noticia = noticia.replaceAll("é","e");
		noticia = noticia.replaceAll("ú","u");
		noticia = noticia.replaceAll("í","i");

		String str = "";
		String [] oss = noticia.split(" ");

		for(int i = 0; i < oss.length; i++) {
	         for (int j = i+1; j < oss.length; j++) {
	            if(oss[i].compareTo(oss[j]) > 0) {
	               String temp = oss[i];
	               oss[i] = oss[j];
	               oss[j] = temp;
	            }
	         }
	    }
		
		for(int i = 0 ; i < oss.length ; i++) {
			if(oss[i].length() > 3) {
				str += oss[i];
				str += " ";
			}
		}
		
		str = str.toLowerCase();
		oss = str.split(" ");
		str = "";
		TreeSet<String> hs = new TreeSet<String>();
		for(int i = 0 ; i < oss.length ; i++) {
			hs.add(oss[i]);
		}
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			str += (String) it.next();
			str += " ";
		}
		
		return str;
	}
	
}
