package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Utility class, ami a szkeleton UI-hoz használandó API-t tartalmazza.
 */
public class SkeletonUI {

	private static int indentation = 0;

	private static Dictionary<Object, String> objects = new Hashtable<Object, String>();

	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	/**
	 * A függvény ami a létrehozott objektumokat regisztrálja be a nevükkel.
	 * 
	 * FONTOS: ha listát adsz hozzá, akkor az utolsó módosítás után tedd ezt,
	 * mert amúgy az már nem ugyanaz az objektum és elromlik a dolog.
	 * 
	 * @param object
	 *            - az új objektum
	 * @param name
	 *            - a neve
	 * @param loud
	 *            - true, ha a létrehozásnak látszania kell a
	 *            szekvenciadiagramon, false, ha nem
	 */
	public static void addObject(Object object, String name, boolean loud) {
		objects.put(object, "\"" + name + "\"");

		if (loud) {
			indent();
			System.out.println("[CREATED] " + writeObject(object));
		}
	}

	/**
	 * A függvények belépési pontján kell hívni.
	 * 
	 * @param who
	 *            - ide csak azt írd hogy this
	 * @param function
	 *            - a függvény neve, ahonnan hívod
	 * @param params
	 *            - írd le a függvény paramétereit egymás után sorba
	 */
	public static void enterFunction(Object who, String function,
			Object... params) {

		indent();
		System.out.print("[ENTERED] \"" + function + "\" function of "
				+ writeObject(who));

		if (params.length > 0) {
			System.out.println(", with the following parameters:");

			indentation++;

			for (Object p : params) {
				indent();
				System.out.println(writeObject(p));
			}
		} else {
			indentation++;
			System.out.println();
		}
	}

	/**
	 * A függvény kilépési pontján kell hívni.
	 */
	public static void leaveFunction() {
		indentation--;

		indent();
		System.out.println("[LEFT]");
	}

	/**
	 * A függvény kilépési pontján kell hívni.
	 * 
	 * @param ret
	 *            - a visszatérési érték
	 */
	public static void leaveFunction(Object ret) {
		indentation--;

		indent();
		System.out.println("[LEFT] with the returning value of "
				+ writeObject(ret));
	}

	/**
	 * A függvény amit eldöntendõ kérdések feltételénél kell hívni.
	 * 
	 * @param question
	 *            - a kérdés
	 * @return a kapott válasz
	 */
	public static boolean booleanQuestion(String question) {
		boolean ret = false;

		questionStart();

		System.out.println(question + " (Y/N)");

		try {
			String answer = reader.readLine().toUpperCase();

			while (!answer.equals("Y") && !answer.equals("N")) {
				System.out.println("Wrong answer format, try again! (Y/N)");
				answer = reader.readLine().toUpperCase();
			}

			if (answer.equals("Y")) {
				ret = true;
			}
		} catch (IOException e) {
			System.err.println("Unhandled I/O exception...");
			e.printStackTrace();
		}

		questionEnd();
		return ret;
	}

	/**
	 * A függvény amit a többválaszos kérdések feltételénél kell hívni.
	 * 
	 * @param question
	 *            - a kérdés: tartalmazza a lehetséges válaszok teljes alakját!
	 * @param possibleAnswers
	 *            - a lehetséges válaszok felsorolva (általában betûk...)
	 * @return a kapott válasz (FONTOS: mindig nagybetû!)
	 */
	public static String stringQuestion(String question,
			String... possibleAnswers) {

		for (int i = 0; i < possibleAnswers.length; i++) {
			possibleAnswers[i] = possibleAnswers[i].toUpperCase();
		}

		String ret = null;

		questionStart();

		System.out.println(question + " " + optionsList(possibleAnswers));

		try {
			String answer = reader.readLine().toUpperCase();

			while (!contains(possibleAnswers, answer)) {
				System.out.println("Wrong answer format, try again! "
						+ optionsList(possibleAnswers));
				answer = reader.readLine().toUpperCase();
			}

			ret = answer;
		} catch (IOException e) {
			System.err.println("Unhandled I/O exception...");
			e.printStackTrace();
		}

		questionEnd();
		return ret;
	}

	private static String optionsList(String[] options) {
		StringBuilder sb = new StringBuilder();

		sb.append("(");

		for (int i = 0; i < options.length; i++) {

			sb.append(options[i]);

			if (i < options.length - 1) {
				sb.append("/");
			}
		}

		sb.append(")");

		return sb.toString();
	}

	private static boolean contains(String[] list, String a) {
		for (String unit : list) {
			if (a.equals(unit))
				return true;
		}

		return false;
	}

	private static void questionStart() {
		System.out
				.println("-------------------- QUESTION --------------------");
	}

	private static void questionEnd() {
		System.out
				.println("--------------------------------------------------");
	}

	private static void indent() {
		for (int i = 0; i < indentation; i++)
			System.out.print("   ");
	}

	private static String writeObject(Object o) {
		StringBuilder sb = new StringBuilder();

		if (objects.get(o) != null) {
			sb.append(objects.get(o));
		} else {
			sb.append(o);
		}

		sb.append(" : ");
		sb.append(o.getClass().getSimpleName());

		return sb.toString();
	}

	/**
	 * Hívd meg a program végén, hogy felszabaduljanak az erõforrások.
	 */
	public static void cleanUp() {
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Unhandled I/O exception...");
			e.printStackTrace();
		}
	}

}
