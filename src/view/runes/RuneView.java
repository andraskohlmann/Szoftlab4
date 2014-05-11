package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.Rune;
import view.RelativeViewBase;

/**
 * 
 * Általános Rune megjelenítéséért felelõs objektum,megvalósítja a
 * RelativeViewBase interfészt
 * 
 */
public class RuneView implements RelativeViewBase {
	/**
	 * Megvalósítandó Rune tárolása
	 */
	private Rune rune;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Rune - megvalósítandó objektum beállítása
	 */
	public RuneView(Rune r) {
		rune = r;
	}

	/**
	 * Getter függvény a tárolt Rune objektumra
	 * 
	 * @return rune Rune
	 */
	public Rune getRune() {
		return rune;
	}

	/**
	 * Az alap default Rune színét állítja be
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void setColor(Graphics g) {
		g.setColor(Color.YELLOW);
	}

	/**
	 * Kirajzolja a Rune-t a paraméterben megkapott x,y koordinátákra
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public void draw(Graphics g, int x, int y) {
		setColor(g);
		g.fillPolygon(new int[] { x + 5, x + 10, x + 15, x + 10 }, new int[] {
				y + 10, y + 15, y + 10, y + 5 }, 4);
	}
}
