package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.HobbitRune;

/**
 * A j�t�kban megjelen� HobbitRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class HobbitRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            HobbitRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public HobbitRuneView(HobbitRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja a HobbitRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.ORANGE);
	}

}
