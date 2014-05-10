package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja a ReloadRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.MAGENTA);
	}

}
