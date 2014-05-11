package view;

import java.awt.Graphics;

import common.Common;

/**
 * 
 * �soszt�ly mely a koordin�t�k kezel�s�hez ny�jt seg�ts�get
 * 
 */
public abstract class ViewBase {
	/**
	 * x koordin�ta
	 */
	protected int x;
	/**
	 * y koordin�ta
	 */
	protected int y;

	/**
	 * Konstrukor
	 * 
	 * @param x
	 *            int - modellbeli x koordin�t�b�l konverzi� view-belire
	 * @param y
	 *            int - modellbeli y koordin�t�b�l konverzi� view-belire
	 */
	public ViewBase(int x, int y) {
		this.x = x * Common.tileWidth;
		this.y = y * Common.tileWidth;
	}

	/**
	 * Abstract kirajzol� f�ggv�ny
	 * 
	 * @param g
	 *            Graphics
	 */
	public abstract void draw(Graphics g);
}
