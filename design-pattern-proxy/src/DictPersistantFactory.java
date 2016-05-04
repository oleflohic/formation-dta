
public class DictPersistantFactory {
	public DictPersistantFactory () {
	}
	
	public DictPersistantIntf<?> creerDictPersistant (int type) {
		
		switch (type) {
		case 0:
			return new DictPersistantProxy<String>();
		case 1:
			return new DictPersistant<String>();
		default:
			return null;
		}
		
	}
}
