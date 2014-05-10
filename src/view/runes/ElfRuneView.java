package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ElfRune;

/**
 * A j�t�kban megjelen� ElfRune megjelen�t�s�rt felel�s objektum,�soszt�lya a
 * default RuneView
 * 
 * 
 */
public class ElfRuneView extends RuneView {
	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            ElfRune - melynek a megjelen�t�s��rt felel az objektum
	 */
	public ElfRuneView(ElfRune r) {
		super(r);
	}

	/**
	 * A met�dus be�ll�tja a sz�nt ami reprezent�lja az ElfRune-t a j�t�kban
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.GREEN);
	}

}
