package view.runes;

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
		g.drawImage(reload, x, y, null);
	}
}
