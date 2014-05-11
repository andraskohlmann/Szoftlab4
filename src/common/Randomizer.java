package common;

import java.util.Random;

public class Randomizer {

	private static Random random = new Random();

	public static int randomInt(int max) {
		return random.nextInt(max);
	}

	public static boolean randomBoolean(int percentage) {
		return random.nextInt(100) < percentage;
	}
}
