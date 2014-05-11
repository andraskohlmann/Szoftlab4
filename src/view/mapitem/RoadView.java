package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.enemies.EnemyUnit;
import model.mapitem.Road;
import view.RelativeViewBase;

/**
 * 
 * A játékban szereplõ Road objektumok megjelenítéséért felelõs objektum, mely
 * leszármazik az általánosabb TileViewBase objektumból
 * 
 */
public class RoadView extends TileViewBase {
	/**
	 * Megjelenítendõ Road objektum
	 */
	private Road road;
	private static BufferedImage image;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Road - kirajzolandó objektum
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public RoadView(Road r, int x, int y) {
		super(x, y);

		road = r;
		try {
			image = ImageIO.read(new File("textures//road.png"));
		} catch (IOException e) {
			System.out.println("HIBA: Képfájl hiányzik!");
		}
	}

	/**
	 * A Road objektum kirajzolását végzõ függvény. Kirajzolja a megfelelõ
	 * helyre, valamint ha található rajta mocsár vagy ellenséges egység, ugy
	 * mindre meghívja a megfelelõ kirajzoló függvényt.
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void paintMe(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawImage(image, x, y, null);

		if (road.hasSwamp()) {
			((RelativeViewBase) road.getSwamp().getView()).draw(g, x, y);
		}
		for (EnemyUnit eu : road.getEnemyList()) {
			((RelativeViewBase) eu.getView()).draw(g, x, y);
		}
	}

}