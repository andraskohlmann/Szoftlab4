package view.runes;

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
		g.drawImage(hobbit, x, y, null);
	}
}
