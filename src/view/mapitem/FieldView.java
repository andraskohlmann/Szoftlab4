package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.mapitem.Field;
import view.RelativeViewBase;

/**
 * 
 * A játékban szereplõ Field objektumok megjelenítéséért felelõs objektum, mely
 * leszármazik az általánosabb TileViewBase objektumból
 * 
 */
public class FieldView extends TileViewBase {
	/**
	 * Megjelenítendõ Field objektum tárolása
	 */
	private Field field;
	private static BufferedImage image;

	/**
	 * Konstruktor
	 * 
	 * @param f
	 *            Field - a megvalósítandó objektum
	 * @param x
	 *            int - x koordinátája
	 * @param y
	 *            int - y koordinátája
	 */
	public FieldView(Field f, int x, int y) {
		super(x, y);

		field = f;
		try {
			image = ImageIO.read(new File("textures//field.png"));
		} catch (IOException e) {
			System.out.println("HIBA: Képfájl hiányzik!");
		}
	}

	/**
	 * A kirajzolást megvalósító függvény,kirajzolja a Field-mezõt,valamint
	 * amennyiben a Fielden köd, vagy torony tartózkodik, úgy megvhívja ezen
	 * objektumok megfelelõ kirajzoló függvényeit.
	 * 
	 * @param g
	 *            Graphics
	 */
	protected void paintMe(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawImage(image, x, y, null);

		if (field.hasTower()) {
			((RelativeViewBase) field.getTower().getView()).draw(g, x, y);
		}

		if (field.hasFog()) {
			((RelativeViewBase) field.getFog().getView()).draw(g, x, y);
		}
	}
}
