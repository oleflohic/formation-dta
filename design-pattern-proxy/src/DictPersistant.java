import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DictPersistant<T> implements DictPersistantIntf<T> {
	
	@Override
	public boolean ajoute(String cle, T objet) {
		try {
			File fichierSortie = new File("donnees/"+cle);
			if (fichierSortie.createNewFile()) {
				FileOutputStream streamSortie = new FileOutputStream(fichierSortie);
				ObjectOutputStream streamObjet = new ObjectOutputStream(streamSortie);
				streamObjet.writeObject(objet);
				streamObjet.flush();
				streamSortie.close();
				return true;
			}
		} catch (IOException e) {
			return false;
		}
		return false;
	}
	
	@SuppressWarnings({"unchecked"})
	public T get(String cle) {
		try {
			File fichierLecture = new File("donnees/"+cle);
			if (fichierLecture.exists()) {
				T resultat;
				FileInputStream streamLecture = new
				FileInputStream(fichierLecture);
				ObjectInputStream streamObjet = new
				ObjectInputStream(streamLecture);
				try {
					resultat = (T)streamObjet.readObject();
				} catch (ClassNotFoundException e) {
					resultat = null;
				}
				streamLecture.close();
				return resultat;
			}
		} catch (IOException e) {
			return null;
		}
		return null;
	}

}
