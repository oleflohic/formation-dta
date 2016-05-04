
public class Main {

	
	public static void main(String[] args) {
		
		/*
		DictPersistant<String> dict = new DictPersistant<String>();

		dict.ajoute("a1", "A 1");
		dict.ajoute("b1", "B 1");
		dict.ajoute("c3", "C 3");
		*/
		
		
		//DictPersistantFactory dpf = new DictPersistantFactory (); 
		//DictPersistant<String> dp = (DictPersistant<?>) dpf.creerDictPersistant(0);
		
		String[] lettres = {"a", "b", "c", "d", "e"};
		String[] noms = new String[20];
		for (int i = 0 ; i < noms.length ; i++) {
			noms[i] = lettres[(int)(Math.random() * lettres.length)] + (int)(Math.random() * 10);
		}
		
		DictPersistantProxy<String> dp = new DictPersistantProxy<String>();
		dp.setDictionnaire(new DictPersistant<String>());
		
		for (int i = 0 ; i < 30 ; i++) {
			
			// ajout
			if (Math.random() < 0.5f) {
				String nomAjoute = noms[(int)(Math.random() * lettres.length)];
				System.out.println("Ajout de " + nomAjoute);
				System.out.println(dp.ajoute(nomAjoute, nomAjoute.toUpperCase()));
			// lecture
			} else {
				String nomLu = noms[(int)(Math.random() * lettres.length)];
				System.out.println("Lecture de " + nomLu);
				System.out.println(dp.get(nomLu));
			}
			
		}
		
		/*
		System.out.println("get: " + dp.get("a1"));
		System.out.println("ajoute: " + dp.ajoute("a1", "A 1"));
		System.out.println("get: " + dp.get("a1"));
		System.out.println("get: " + dp.get("c3"));
		*/
		
		
	}

}
