package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.DwarfRune;

/**
 * A j�t�kban megjelen� DwarfRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class DwarfRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            DwarfRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public DwarfRuneView(DwarfRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja a DwarfRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	protected void setColor(Graphics g) {
		g.setColor(Color.BLACK);
	}

}
