package util;

public class IdGenerator {
	
	private static int idCounter = 0;

	private IdGenerator() {
	}

	public static int generate() {
		idCounter++;
		return idCounter;
	}

}
