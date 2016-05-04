package partie2;

public class FactoryFactory {

	public FactoryFactory() {
	}
	
	public Factory buildFactory (int code) {
		switch (code) {
		case 0:
			return new WindowsFactory();

		case 1:
			return new LinuxFactory();
			
		default:
			return null;
		}
	}

}
