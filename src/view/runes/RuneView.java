package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.Rune;
import view.RelativeViewBase;

/**
 * 
 * �ltal�nos Rune megjelen�t�s��rt felel�s objektum,megval�s�tja a
 * RelativeViewBase interf�szt
 * 
 */
public class RuneView implements RelativeViewBase {
	/**
	 * Megval�s�tand� Rune t�rol�sa
	 */
	private Rune rune;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Rune - megval�s�tand� objektum be�ll�t�sa
	 */
	public RuneView(Rune r) {
		rune = r;
	}

	/**
	 * Getter f�ggv�ny a t�rolt Rune objektumra
	 * 
	 * @return rune Rune
	 */
	public Rune getRune() {
		return rune;
	}

	/**
	 * Az alap default Rune sz�n�t �ll�tja be
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void setColor(Graphics g) {
		g.setColor(Color.YELLOW);
	}

	/**
	 * Kirajzolja a Rune-t a param�terben megkapott x,y koordin�t�kra
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public void draw(Graphics g, int x, int y) {
		setColor(g);
		g.fillPolygon(new int[] { x + 5, x + 10, x + 15, x + 10 }, new int[] {
				y + 10, y + 15, y + 10, y + 5 }, 4);
	}
}
