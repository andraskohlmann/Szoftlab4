package view;

import java.awt.Graphics;

import common.Common;

/**
 * 
 * Õsosztály mely a koordináták kezeléséhez nyújt segítséget
 * 
 */
public abstract class ViewBase {
	/**
	 * x koordináta
	 */
	protected int x;
	/**
	 * y koordináta
	 */
	protected int y;

	/**
	 * Konstrukor
	 * 
	 * @param x
	 *            int - modellbeli x koordinátából konverzió view-belire
	 * @param y
	 *            int - modellbeli y koordinátából konverzió view-belire
	 */
	public ViewBase(int x, int y) {
		this.x = x * Common.tileWidth;
		this.y = y * Common.tileWidth;
	}

	/**
	 * Abstract kirajzoló függvény
	 * 
	 * @param g
	 *            Graphics
	 */
	public abstract void draw(Graphics g);
}
