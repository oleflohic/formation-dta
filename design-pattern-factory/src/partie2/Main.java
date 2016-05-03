package partie2;
public class Main {
	
	public static void main (String[] args) {
		main_parse_filename(args[0]);
	}
	
	public static void main_parse_filename (String path) {
		
		//index est l'endroit où se situe, dans la String path, la dernière
		//apparition du caractère \
		
		int index = path.lastIndexOf("\\");
		
		//On construit une String qui ne contient que la partie située à droite
		//du dernier caractère \
		String r = path.substring(index + 1);
		
		System.out.println(r);
	}
	
}
