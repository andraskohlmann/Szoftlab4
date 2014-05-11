package view.friendly;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.friendly.Swamp;
import view.RelativeViewBase;

/**
 * 
 * A játékban megjelenõ mocsarak kirajzolásáért felelõs objektum,leszármazik a
 * RelativeViewBase osztályból.
 * 
 */
public class SwampView implements RelativeViewBase {
	/**
	 * A kirajzolandó objektum tárolása
	 */
	private Swamp swamp;
	private static BufferedImage image;

	/**
	 * Konstruktor
	 * 
	 * @param s
	 *            Swamp
	 */
	public SwampView(Swamp s) {
		swamp = s;
		try {
			image = ImageIO.read(new File("textures//swamp.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A mocsarat kirajzoló függvény. A helyes koordintákra kirajzol, valamint a
	 * mocsárra lehelyezett Rune kirajzolását megvalósító függvényt is meghívja.
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

		((RelativeViewBase) swamp.getRune().getView()).draw(g, x, y);
	}
}
