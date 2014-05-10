package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja az ElfRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.GREEN);
	}

}
