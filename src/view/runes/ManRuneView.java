package view.runes;

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
		g.drawImage(man, x, y, null);
	}
}
