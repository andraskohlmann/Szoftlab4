package view.mapitem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.RelativeViewBase;

/**
 * 
 * A játékban megjelenõ köd kirajzolásáért felelõs objektum, leszármazik a
 * RelativeViewBase objektumból
 * 
 */
public class FogView implements RelativeViewBase {

	private static BufferedImage image;
	
	public FogView() {
		try {
			image = ImageIO.read(new File("textures//fog.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a ködöt a megfelelõ helyre a pályán.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	@Override
	public void draw(Graphics g, int x, int y) {

		g.drawImage(image, x, y, null);
	}

}
