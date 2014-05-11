package view.runes;

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
	 * A r�na kirajzol�sa
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordin�ta
	 * @param y
	 * 			  int - y koordin�ta
	 *            
	 */
	@Override
	protected void drawRune(Graphics g, int x, int y) {
		g.drawImage(range, x, y, null);
	}
}
