package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja a DwarfRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	protected void setColor(Graphics g) {
		g.setColor(Color.BLACK);
	}

}
