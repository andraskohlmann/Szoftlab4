package view;

import java.awt.Graphics;

/**
 * 
 * Interf�sz a Field,Road objektumokra val� tov�bbi rajzol�shoz
 * 
 */
public interface RelativeViewBase {
	/**
	 * Kirajzol�st megval�s�t� f�ggv�ny
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	void draw(Graphics g, int x, int y);

}
