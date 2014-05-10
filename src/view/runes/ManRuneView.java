package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja a ManRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

}
