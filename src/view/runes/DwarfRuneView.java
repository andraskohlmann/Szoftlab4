package view.runes;

import java.awt.Graphics;

import model.runes.DwarfRune;

/**
 * A játékban megjelenõ DwarfRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class DwarfRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            DwarfRune - melynek a megjelenítéséért felel az objektum
	 */
	public DwarfRuneView(DwarfRune r) {
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
		g.drawImage(dwarf, x, y, null);
	}
}
