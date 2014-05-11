package view.runes;

import java.awt.Graphics;

import model.runes.ElfRune;

/**
 * A játékban megjelenõ ElfRune megjelenítésért felelõs objektum,õsosztálya a
 * default RuneView
 * 
 * 
 */
public class ElfRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ElfRune - melynek a megjelenítéséért felel az objektum
	 */
	public ElfRuneView(ElfRune r) {
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
		g.drawImage(elf, x, y, null);
	}
}
