package view.runes;

import java.awt.Graphics;

import model.runes.RangeRune;

/**
 * A játékban megjelenõ RangeRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class RangeRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            RangeRune - melynek a megjelenítéséért felel az objektum
	 */
	public RangeRuneView(RangeRune r) {
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
		g.drawImage(range, x, y, null);
	}
}
