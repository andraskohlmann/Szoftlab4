package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ManRune;

/**
 * A j�t�kban megjelen� ManRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class ManRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ManRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public ManRuneView(ManRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja a ManRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

}
