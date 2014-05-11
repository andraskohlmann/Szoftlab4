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
 * A játékban megjelenõ tornyok kirajzolásáért felelõs objektum,leszármazik a
 * RelativeViewBase osztályból.
 * 
 */
public class TowerView implements RelativeViewBase {
	/**
	 * A kirajzolandó objektum tárolása
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
	 * A tornyot kirajzoló függvény. A helyes koordintákra kirajzol, valamint a
	 * toronyra lehelyezett Rune kirajzolását megvalósító függvényt is meghívja.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);

		((RelativeViewBase) tower.getRune().getView()).draw(g, x, y);
	}
}
