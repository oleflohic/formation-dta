package partie2;
public class Main {
	
	public static void main (String[] args) {
		main_parse_filename(args[0]);
	}
	
	public static void main_parse_filename (String path) {
		
		//index est l'endroit o� se situe, dans la String path, la derni�re
		//apparition du caract�re \
		
		int index = path.lastIndexOf("\\");
		
		//On construit une String qui ne contient que la partie situ�e � droite
		//du dernier caract�re \
		String r = path.substring(index + 1);
		
		System.out.println(r);
	}
	
}
