package view;

import java.awt.Graphics;

/**
 * 
 * Interfész a Field,Road objektumokra való további rajzoláshoz
 * 
 */
public interface RelativeViewBase {
	/**
	 * Kirajzolást megvalósító függvény
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	void draw(Graphics g, int x, int y);

}
