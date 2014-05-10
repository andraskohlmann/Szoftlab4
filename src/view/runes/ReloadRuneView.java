package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ReloadRune;

/**
 * A j�t�kban megjelen� ReloadRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class ReloadRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ReloadRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public ReloadRuneView(ReloadRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja a ReloadRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.MAGENTA);
	}

}
