package view.mapitem;

import java.awt.Graphics;

import view.View;
import view.ViewBase;

/**
 * 
 * Általános kirajzolásért felelõs objektum, mely származik a ViewBase
 * osztályból, és implementálja a View interfészt. Felelõssége a Road,Field
 * objektumok egybefogása, közös kezelhetõségének biztosítása. Továbbá a
 * modellbeli objektumok jelezhetnek neki amennyiben változást történt és
 * újrarajzolás szükséges.
 * 
 */
public abstract class TileViewBase extends ViewBase implements View {
	/**
	 * Amennyiben újrarajzolás szükséges, úgy a változó értéke igazba billen
	 */
	private boolean needToRepaint;

	/**
	 * Konstruktor
	 * 
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public TileViewBase(int x, int y) {
		super(x, y);

		needToRepaint = true;
	}

	/**
	 * A függvény meghívásával jelezhetõ a modellbeli változás, így a kirajzolás
	 * szükségessége.
	 */
	@Override
	public void notifyView() {
		needToRepaint = true;
	}

	/**
	 * Kirajzolást végzõ függvény, meghívja a leszármazott osztályokban
	 * megvalósított paintMe függvényt.
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	public void draw(Graphics g) {
		if (needToRepaint) {
			paintMe(g);

			needToRepaint = false;
		}
	}

	/**
	 * Abstract metódus mely az egyes leszármazott objektumok implementálnak. A
	 * leszármazott objektumok kirajzolását valósítjuk meg vele
	 * 
	 * @param g
	 *            Graphics
	 */
	protected abstract void paintMe(Graphics g);

}
