import java.util.ArrayList;
public class Principal {

	public static void main(String[] args) {
		String teste = "João é um botijão";
		TratadorString noticia = new TratadorString(teste);
		
		 noticia.filtro();
		 
		 ArrayList<String> list = new ArrayList<String>(); 
		  
	  
	        // Iterator to traverse the list 
	        Iterator iterator = list.iterator(); 
	  
	        System.out.println("List elements : "); 
	  
	        while (iterator.hasNext()) 
	            System.out.print(iterator.next() + " "); 
	  
	        System.out.println(); 
				
		for(String str : noticia) {
			System.out.println(str);
		}
	}

}