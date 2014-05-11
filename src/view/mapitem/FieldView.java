package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import common.Common;

import model.mapitem.Field;
import view.RelativeViewBase;

/**
 * 
 * A játékban szereplõ Field objektumok megjelenítéséért felelõs objektum, mely
 * leszármazik az általánosabb TileViewBase objektumból
 * 
 */
public class FieldView extends TileViewBase {
	/**
	 * Megjelenítendõ Field objektum tárolása
	 */
	private Field field;

	/**
	 * Konstruktor
	 * 
	 * @param f
	 *            Field - a megvalósítandó objektum
	 * @param x
	 *            int - x koordinátája
	 * @param y
	 *            int - y koordinátája
	 */
	public FieldView(Field f, int x, int y) {
		super(x, y);

		field = f;
	}

	/**
	 * A kirajzolást megvalósító függvény,kirajzolja a Field-mezõt,valamint
	 * amennyiben a Fielden köd, vagy torony tartózkodik, úgy megvhívja ezen
	 * objektumok megfelelõ kirajzoló függvényeit.
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, Common.tileWidth, Common.tileWidth);

		if (field.hasTower()) {
			((RelativeViewBase) field.getTower().getView()).draw(g, x, y);
		}

		if (field.hasFog()) {
			((RelativeViewBase) field.getFog().getView()).draw(g, x, y);
		}
	}
}
