package view.runes;

import java.awt.Graphics;

import model.runes.ReloadRune;

/**
 * A játékban megjelenõ ReloadRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class ReloadRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ReloadRune - melynek a megjelenítéséért felel az objektum
	 */
	public ReloadRuneView(ReloadRune r) {
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
		g.drawImage(reload, x, y, null);
	}
}
