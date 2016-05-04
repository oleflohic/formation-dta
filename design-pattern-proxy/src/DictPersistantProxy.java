import java.util.HashMap;

public class DictPersistantProxy<T> implements DictPersistantIntf<T> {
	
	private HashMap<String,T> donnees;
	private DictPersistant<T> dictionnaire;
	
	public DictPersistantProxy () {
		donnees = new HashMap<String,T>();
	}
	
	public void setDictionnaire (DictPersistant<T> dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
	
	@Override
	public boolean ajoute(String cle, T objet) {
		if (donnees.containsKey(cle)) {
			System.out.println("" + cle + " en cache");
			return false;
		} else {
			boolean resultat = dictionnaire.ajoute(cle, objet);
			donnees.put(cle, objet);
			System.out.println("" + cle + " ajouté au cache");
			return resultat;
		}
	}

	@Override
	public T get(String cle) {
		if (donnees.containsKey(cle)) {
			System.out.println("" + cle + " en cache");
			return donnees.get(cle);
		} else {
			T resultat = dictionnaire.get(cle);
			donnees.put(cle, resultat);
			System.out.println("" + cle + " ajouté au cache");
			return resultat;
		}
	}

}
