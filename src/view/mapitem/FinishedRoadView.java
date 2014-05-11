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
 * A j�t�kban megjelen� FinishedRoad kirajzol�s��rt felel�s objektum,a ViewBase
 * oszt�ly lesz�rmazottja
 * 
 */
public class FinishedRoadView extends ViewBase {
	
	private static BufferedImage image;
	/**
	 * Konstruktor, mely be�ll�tja a kirajzol�s hely�t
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
	 * Kirajzol� f�ggv�ny, mely a megfelel� helyre kirajzolja a FinishedRoad-ot
	 * 
	 * @param g
	 *            Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
}
