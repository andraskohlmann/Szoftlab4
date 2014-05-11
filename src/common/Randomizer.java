package common;

import java.util.Random;

public class Randomizer {

	
	
	public static int randomInt(int max) {
		Random r = new Random();
		return r.nextInt(max);

	}

	public static boolean randomBoolean(int percentage) {
		Random r = new Random();
		int number = r.nextInt(100);
		if (number < 50)
			return true;
		else
			return false;
	}
}
