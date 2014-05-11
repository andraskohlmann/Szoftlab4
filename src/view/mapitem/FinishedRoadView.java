package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import common.Common;

import view.ViewBase;

/**
 * 
 * A játékban megjelenõ FinishedRoad kirajzolásáért felelõs objektum,a ViewBase
 * osztály leszármazottja
 * 
 */
public class FinishedRoadView extends ViewBase {
	
	private static BufferedImage image;
	/**
	 * Konstruktor, mely beállítja a kirajzolás helyét
	 * 
	 * @param x
	 * @param y
	 */
	public FinishedRoadView(int x, int y) {
		super(x, y);
		
		try {
			image = ImageIO.read(new File("textures//mount.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kirajzoló függvény, mely a megfelelõ helyre kirajzolja a FinishedRoad-ot
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
}
