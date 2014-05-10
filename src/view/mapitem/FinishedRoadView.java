package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;

import view.ViewBase;

/**
 * 
 * A játékban megjelenõ FinishedRoad kirajzolásáért felelõs objektum,a ViewBase
 * osztály leszármazottja
 * 
 */
public class FinishedRoadView extends ViewBase {
	/**
	 * Konstruktor, mely beállítja a kirajzolás helyét
	 * 
	 * @param x
	 * @param y
	 */
	public FinishedRoadView(int x, int y) {
		super(x, y);
	}

	/**
	 * Kirajzoló függvény, mely a megfelelõ helyre kirajzolja a FinishedRoad-ot
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, Common.tileWidth, Common.tileWidth);
	}
}
