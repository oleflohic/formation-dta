
public interface DictPersistantIntf<T> {
	boolean ajoute (String cle, T objet);
	T get(String cle);
}
