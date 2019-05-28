
public class TratadorString {
	protected String noticia;
	
	public TratadorString(String s_) {
		noticia = s_;
	}
	
	public void filtro() {
		noticia = noticia.replaceAll("[\\.$|,|;|']", "");
		noticia = noticia.replaceAll("[ã á à]", "a");
		noticia = noticia.replaceAll("[õ ó]","o" );
		noticia = noticia.replaceAll("é","e");
		noticia = noticia.replaceAll("ú","u");
		noticia = noticia.replaceAll("í","i");

		String [] split = noticia.split(" ");
		
		for(int i = 0 ; i < split.length ; i++) {
			if(split[i].length() <= 3) {
				noticia = noticia.replaceAll(split[i], "");
			}
		}
		
		
	}
}
