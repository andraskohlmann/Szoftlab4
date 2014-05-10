package view.runes;

import java.awt.Color;
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
	 * A metódus beállítja a színt ami reprezentálja a RangeRune-t a játékban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
	}

}
