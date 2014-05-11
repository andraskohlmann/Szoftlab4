package view.runes;

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
		g.drawImage(elf, x, y, null);
	}
}
