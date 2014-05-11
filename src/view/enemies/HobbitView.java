package view.enemies;

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
	 * Az egység kirajzolása
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordináta
	 * @param y
	 * 			  int - y koordináta
	 *            
	 */
	@Override
	protected void drawUnit(Graphics g, int x, int y) {
		g.drawImage(hobbit, x, y, null);
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
