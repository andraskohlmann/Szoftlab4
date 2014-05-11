package view.runes;

import java.awt.Graphics;

import model.runes.HobbitRune;

/**
 * A játékban megjelenõ HobbitRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class HobbitRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            HobbitRune - melynek a megjelenítéséért felel az objektum
	 */
	public HobbitRuneView(HobbitRune r) {
		super(r);
	}

	/**
	 * A rúna kirajzolása
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordináta
	 * @param y
	 * 			  int - y koordináta
	 *            
	 */
	@Override
	protected void drawRune(Graphics g, int x, int y) {
		g.drawImage(hobbit, x, y, null);
	}
}
