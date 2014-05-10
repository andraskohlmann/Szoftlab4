package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;

import view.ViewBase;

/**
 * 
 * A j�t�kban megjelen� FinishedRoad kirajzol�s��rt felel�s objektum,a ViewBase
 * oszt�ly lesz�rmazottja
 * 
 */
public class FinishedRoadView extends ViewBase {
	/**
	 * Konstruktor, mely be�ll�tja a kirajzol�s hely�t
	 * 
	 * @param x
	 * @param y
	 */
	public FinishedRoadView(int x, int y) {
		super(x, y);
	}

	/**
	 * Kirajzol� f�ggv�ny, mely a megfelel� helyre kirajzolja a FinishedRoad-ot
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, Common.tileWidth, Common.tileWidth);
	}
}
