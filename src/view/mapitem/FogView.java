package view.mapitem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.RelativeViewBase;

/**
 * 
 * A j�t�kban megjelen� k�d kirajzol�s��rt felel�s objektum, lesz�rmazik a
 * RelativeViewBase objektumb�l
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
	 * Kirajzolja a k�d�t a megfelel� helyre a p�ly�n.
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	@Override
	public void draw(Graphics g, int x, int y) {

		g.drawImage(image, x, y, null);
	}

}
