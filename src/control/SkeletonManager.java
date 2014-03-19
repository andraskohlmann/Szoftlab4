package control;

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
//		Game game = new Game();
//		addObject(game, "game", true);
//		game.tick();

	}

	public static void addObject(Object object, String name, boolean loud) {
		objects.put(object, "\"" + name +  "\"");
		
		if (loud) {
			indent();
			System.out.println("[CREATED] " + writeObject(object));
		}
	}

	public static void enterFunction(Object who, String function,
			Object[] params) {
		
		indent();
		System.out.print("[ENTERED] \"" + function + "\" function of "
				+ writeObject(who));

		if (params != null) {
			System.out.println(", with the following parameters:");
			
			indentation++;
			
			for (Object p : params) {
				indent();
				System.out.println(writeObject(p));
			}
		}
		else {
			indentation++;
			System.out.println();
		}
	}

	public static void leaveFunction(Object ret) {
		indentation--;
		
		indent();
		System.out.print("[LEFT]");
		
		if (ret != null) {
			System.out.println(" with the returning value of: " + writeObject(ret));
		}
		else {
			System.out.println();
		}
	}

	private static void indent() {
		for (int i = 0; i < indentation; i++)
			System.out.print("   ");
	}
	
	private static String writeObject(Object o) {
		return objects.get(o) + " : " + o.getClass().getSimpleName();
	}

}
