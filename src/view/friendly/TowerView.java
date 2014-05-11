package view.friendly;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.friendly.Tower;
import view.RelativeViewBase;

/**
 * 
 * A j�t�kban megjelen� tornyok kirajzol�s��rt felel�s objektum,lesz�rmazik a
 * RelativeViewBase oszt�lyb�l.
 * 
 */
public class TowerView implements RelativeViewBase {
	/**
	 * A kirajzoland� objektum t�rol�sa
	 */
	private Tower tower;
	private static BufferedImage image;

	/**
	 * Konstruktor
	 * 
	 * @param t
	 *            Tower
	 */
	public TowerView(Tower t) {
		tower = t;
		try {
			image = ImageIO.read(new File("textures//tower.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A tornyot kirajzol� f�ggv�ny. A helyes koordint�kra kirajzol, valamint a
	 * toronyra lehelyezett Rune kirajzol�s�t megval�s�t� f�ggv�nyt is megh�vja.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);

		((RelativeViewBase) tower.getRune().getView()).draw(g, x, y);
	}
}
