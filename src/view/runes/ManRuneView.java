package view.runes;

import java.awt.Graphics;

import model.runes.ManRune;

/**
 * A játékban megjelenõ ManRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class ManRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ManRune - melynek a megjelenítéséért felel az objektum
	 */
	public ManRuneView(ManRune r) {
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
		g.drawImage(man, x, y, null);
	}
}
