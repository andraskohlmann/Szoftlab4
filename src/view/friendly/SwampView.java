package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Swamp;
import view.RelativeViewBase;

/**
 * 
 * A játékban megjelenõ mocsarak kirajzolásáért felelõs objektum,leszármazik a
 * RelativeViewBase osztályból.
 * 
 */
public class SwampView implements RelativeViewBase {
	/**
	 * A kirajzolandó objektum tárolása
	 */
	private Swamp swamp;

	/**
	 * Konstruktor
	 * 
	 * @param s
	 *            Swamp
	 */
	public SwampView(Swamp s) {
		swamp = s;
	}

	/**
	 * A mocsarat kirajzoló függvény. A helyes koordintákra kirajzol, valamint a
	 * mocsárra lehelyezett Rune kirajzolását megvalósító függvényt is meghívja.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 2, 16, 16);

		((RelativeViewBase) swamp.getRune().getView()).draw(g, x, y);
	}
}
