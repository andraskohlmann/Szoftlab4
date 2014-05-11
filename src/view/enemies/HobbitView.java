package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.Hobbit;

import common.Common;

/**
 * 
 * Hobbit ellenséges egység megjelenítéséért felelõs objektum, leszármazik az
 * EnemyUnitView osztályból
 * 
 */
public class HobbitView extends EnemyUnitView {
	/**
	 * Konstruktor
	 * 
	 * @param h
	 *            Hobbit
	 */
	public HobbitView(Hobbit h) {
		super(h);
	}

	/**
	 * A megfelelõ színt beállítja a kirajzoláshoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
	}

	/**
	 * Visszaadja a Hobbit egység sebzés nélküli életét.
	 * 
	 * @return life int - a maximum élet ami lehetséges a Hobbit egységeknél
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeHobbit;
	}
}
