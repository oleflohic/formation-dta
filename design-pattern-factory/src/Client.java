public class Client {
	
	
	public static void main (String[] args) {
		
		ProgramFactory factory = new ProgramFactory();
		ProgramInterface program;
		
		if (args.length > 0) {
			program = factory.createProgram(Integer.parseInt(args[0]));
		} else {
			program = factory.createProgram(1);
		}
		
		program.go();
		
	}
	
}
