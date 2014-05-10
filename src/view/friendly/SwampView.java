package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Swamp;
import view.RelativeViewBase;

/**
 * 
 * A j�t�kban megjelen� mocsarak kirajzol�s��rt felel�s objektum,lesz�rmazik a
 * RelativeViewBase oszt�lyb�l.
 * 
 */
public class SwampView implements RelativeViewBase {
	/**
	 * A kirajzoland� objektum t�rol�sa
	 */
	private Swamp swamp;

	/**
	 * Konstruktor
	 * 
	 * @param s
	 *            Swamp
	 */
	public SwampView(Swamp s) {
		swamp = s;
	}

	/**
	 * A mocsarat kirajzol� f�ggv�ny. A helyes koordint�kra kirajzol, valamint a
	 * mocs�rra lehelyezett Rune kirajzol�s�t megval�s�t� f�ggv�nyt is megh�vja.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 2, 16, 16);

		((RelativeViewBase) swamp.getRune().getView()).draw(g, x, y);
	}
}
