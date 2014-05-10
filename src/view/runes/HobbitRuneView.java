package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja a HobbitRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.ORANGE);
	}

}
