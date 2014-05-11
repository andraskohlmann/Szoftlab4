package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import common.Common;

import model.mapitem.Field;
import view.RelativeViewBase;

/**
 * 
 * A j�t�kban szerepl� Field objektumok megjelen�t�s��rt felel�s objektum, mely
 * lesz�rmazik az �ltal�nosabb TileViewBase objektumb�l
 * 
 */
public class FieldView extends TileViewBase {
	/**
	 * Megjelen�tend� Field objektum t�rol�sa
	 */
	private Field field;

	/**
	 * Konstruktor
	 * 
	 * @param f
	 *            Field - a megval�s�tand� objektum
	 * @param x
	 *            int - x koordin�t�ja
	 * @param y
	 *            int - y koordin�t�ja
	 */
	public FieldView(Field f, int x, int y) {
		super(x, y);

		field = f;
	}

	/**
	 * A kirajzol�st megval�s�t� f�ggv�ny,kirajzolja a Field-mez�t,valamint
	 * amennyiben a Fielden k�d, vagy torony tart�zkodik, �gy megvh�vja ezen
	 * objektumok megfelel� kirajzol� f�ggv�nyeit.
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
