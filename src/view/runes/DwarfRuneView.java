package view.runes;

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
		g.drawImage(dwarf, x, y, null);
	}
}
