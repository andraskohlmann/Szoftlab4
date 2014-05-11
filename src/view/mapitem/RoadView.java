package view.mapitem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import common.Common;

import model.enemies.EnemyUnit;
import model.mapitem.Road;
import view.RelativeViewBase;

/**
 * 
 * A j�t�kban szerepl� Road objektumok megjelen�t�s��rt felel�s objektum, mely
 * lesz�rmazik az �ltal�nosabb TileViewBase objektumb�l
 * 
 */
public class RoadView extends TileViewBase {
	/**
	 * Megjelen�tend� Road objektum
	 */
	private Road road;
	private static BufferedImage image;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Road - kirajzoland� objektum
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public RoadView(Road r, int x, int y) {
		super(x, y);

		road = r;
		try {
			image = ImageIO.read(new File("textures//road.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A Road objektum kirajzol�s�t v�gz� f�ggv�ny. Kirajzolja a megfelel�
	 * helyre, valamint ha tal�lhat� rajta mocs�r vagy ellens�ges egys�g, ugy
	 * mindre megh�vja a megfelel� kirajzol� f�ggv�nyt.
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void paintMe(Graphics g) {
		g.drawImage(image, x, y, null);

		if (road.hasSwamp()) {
			((RelativeViewBase) road.getSwamp().getView()).draw(g, x, y);
		}
		
		if(road.getEnemyList().size() == 1)
			((RelativeViewBase) road.getEnemyList().get(0).getView()).draw(g, x + 7, y + 7);
		else {
			int i = 0;
			int j = 0;
			for (EnemyUnit eu : road.getEnemyList()) {
				
				int unitX = x + i * (int)(Common.tileWidth / 2);
				int unitY = y + j * (int)(Common.tileWidth / 2);
				
				((RelativeViewBase) eu.getView()).draw(g, unitX, unitY);
				
				i++;
				if(2 <= i) {
					i = 0;
					j++;
					if(2 <= j)
						j = 0;
				}
			}
		}
	}

}