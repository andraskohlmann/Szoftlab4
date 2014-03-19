package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;

import model.Game;

public class SkeletonManager {

	private static int indentation = 0;

	private static Dictionary<Object, String> objects = new Hashtable<Object, String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		addObject(game, "game", true);
		game.tick();

	}

	/**
	 * A f�ggv�ny ami a l�trehozott objektumokat regisztr�lja be a nev�kkel.
	 * 
	 * @param object
	 *            - az �j objektum
	 * @param name
	 *            - a neve
	 * @param loud
	 *            - true, ha a l�trehoz�snak l�tszania kell a
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
	 * A f�ggv�nyek bel�p�si pontj�n kell h�vni.
	 * 
	 * @param who
	 *            - ide csak azt �rd hogy this
	 * @param function
	 *            - a f�ggv�ny neve, ahonnan h�vod
	 * @param params
	 *            - �rd le a f�ggv�ny param�tereit egym�s ut�n sorba
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
	 * A f�ggv�ny kil�p�si pontj�n kell h�vni.
	 */
	public static void leaveFunction() {
		indentation--;

		indent();
		System.out.println("[LEFT]");
	}

	/**
	 * A f�ggv�ny kil�p�si pontj�n kell h�vni.
	 * 
	 * @param ret
	 *            - a visszat�r�si �rt�k
	 */
	public static void leaveFunction(Object ret) {
		indentation--;

		indent();
		System.out.println("[LEFT] with the returning value of: "
				+ writeObject(ret));
	}
	
	/**
	 * A f�ggv�ny amit eld�ntend� k�rd�sek felt�tel�n�l kell megh�vni.
	 * 
	 * @param question - a k�rd�s
	 * @return a kapott v�lasz
	 */
	public static boolean booleanQuestion(String question) {
		boolean ret = false;
		
		questionStart();
		
		System.out.println(question + " (Y/N)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String answer = br.readLine().toUpperCase();
			
			while (!answer.equals("Y") && !answer.equals("N")) {
				System.out.println("Wrong answer format, try again! (Y/N)");
				answer = br.readLine().toUpperCase();
			}
			
			if (answer.equals("Y")) {
				ret = true;
			}
			
			br.close();
		} catch (IOException e) {
			System.err.println("Unhandled I/O exception...");
			e.printStackTrace();
		}
		
		questionEnd();
		return ret;
	}
	
	public static String stringQuestion(String question, String[] answers) {
		questionStart();
		questionEnd();
		return null;
	}
	
	private static void questionStart() {
		System.out.println("-------------------- QUESTION --------------------");
	}
	
	private static void questionEnd() {
		System.out.println("--------------------------------------------------");
	}

	private static void indent() {
		for (int i = 0; i < indentation; i++)
			System.out.print("   ");
	}

	private static String writeObject(Object o) {
		return objects.get(o) + " : " + o.getClass().getSimpleName();
	}

}
