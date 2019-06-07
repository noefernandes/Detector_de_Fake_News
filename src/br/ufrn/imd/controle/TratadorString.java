package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import org.apache.commons.lang3.StringUtils;

public class TratadorString {
	public String noticia;
	
	public TratadorString(String s_) {
		noticia = s_;
	}

	public String filtro() {
		//remoção de toda pontuação
		noticia = noticia.replaceAll("[-\\.$|'|1234567890]", "");
		noticia = noticia.replaceAll("[?|!|,|;|:|(|)%|]", "");
		//remoção dos acentos
		noticia = StringUtils.stripAccents(noticia);
		
		//string que será usada para receber a lista de string
		String str = "";
		
		// lista de string separada pelos espaços para ser percorrida
		String [] oss = noticia.split(" ");

		//percorrimento que tira as strings iguais
		for(int i = 0; i < oss.length; i++) {
	         for (int j = i+1; j < oss.length; j++) {
	            if(oss[i].compareTo(oss[j]) > 0) {
	               String temp = oss[i];
	               oss[i] = oss[j];
	               oss[j] = temp;
	            }
	         }
	    }
		
		//remoção das palavras menores do que 3
		for(int i = 0 ; i < oss.length ; i++) {
			if(oss[i].length() > 3) {
				str += oss[i];
				str += " ";
			}
		}
		//deixando tudo minusculo
		str = str.toLowerCase();
		oss = str.split(" ");
		str = "";
		// criação e uso de uma tree set para converter a lista de string filtrada a uma string str
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
	
	public String toSHA1(String noticia) {
		try {
			// Uso da classe MessageDigest para instancia o metodo de codificação SHA-1
			// Tal classe exige um lançamento de exceção de não encontrar o algoritmo intanciado
	        MessageDigest conversor = MessageDigest.getInstance("SHA-1"); 
	
	       // converte a string em uma cadei de bytes
	        byte[] cadeia_de_byte = conversor.digest(noticia.getBytes()); 
	
	        // converte a cadeia de byte em uma cadeia de inteiros positivos com a classe "BigInteger"
	        BigInteger cadeia_de_inteiros = new BigInteger(1, cadeia_de_byte); 
	
	        // Converte a cadeia de interios em uma string hexadecimal 
	        String string_hash = cadeia_de_inteiros.toString(16); 
	
	        // caso a string tenha menor do q 32,então ela irá preceder uma cadeia de 0's afim de ter um tamanho padrão de 32
	        while (string_hash.length() < 32) { 
	            string_hash = "0" + string_hash; 
	        } 
	
	        return string_hash; 
		// Caso não seja possivel converter a string em uma cadeia SHA-1
		}catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}
	
}
