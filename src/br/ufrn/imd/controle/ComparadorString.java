package br.ufrn.imd.controle;


public class ComparadorString {
	//https://pt.wikipedia.org/wiki/Dist%C3%A2ncia_Levenshtein
	//https://www.baeldung.com/java-levenshtein-distance
	
	private static ComparadorString instancia;
	
	private ComparadorString() {
		
	}
	
	public static ComparadorString getInstancia() {
		if(instancia == null) {
			instancia = new ComparadorString();
		}
		
		return instancia;
	}
	
	public double distanciaLevenshtein(String str1, String str2) {
		int tamanhoStr1 = str1.length();
		int tamanhoStr2 = str2.length();
		
		//Cria matriz de altura tamanhostr1 + 1 e largura tamanhoStr2 + 1
		int[][] tabela = new int[tamanhoStr1+1][tamanhoStr2+1];
		
		int i, j, custo;
		
		//Insere valores na coluna 0.
		for(i = 0; i <= tamanhoStr1; i++) {
			tabela[i][0] = i;
		}
		
		//Insere valores na linha 0.
		for(j = 0; j <= tamanhoStr2; j++) {
			tabela[0][j] = j;
		}
		
		
		for(i = 1; i <= tamanhoStr1; i++) {
			for(j = 1; j <= tamanhoStr2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					custo = 0;
				}else {
					custo = 1;
				}
				tabela[i][j] = Math.min(tabela[i-1][j] + 1,				//Deletar 
							   Math.min(tabela[i][j-1] + 1, 			//Inserir
									    tabela[i-1][j-1] + custo)); 	//Substituir
			}
		}	
		
		return (1 - ((double) tabela[tamanhoStr1][tamanhoStr2] / Math.max(tamanhoStr1, tamanhoStr2) ) ) *100;
	}
	

}
