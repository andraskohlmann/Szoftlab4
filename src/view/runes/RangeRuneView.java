package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.RangeRune;

/**
 * A j�t�kban megjelen� RangeRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class RangeRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            RangeRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public RangeRuneView(RangeRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja a RangeRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
	}

}
