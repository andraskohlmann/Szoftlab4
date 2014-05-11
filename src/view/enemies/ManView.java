package view.enemies;

import java.awt.Graphics;

import model.enemies.Man;

import common.Common;

/**
 * 
 * Man ellenséges egység megjelenítéséért felelõs objektum, leszármazik az
 * EnemyUnitView osztályból
 * 
 */
public class ManView extends EnemyUnitView {
	/**
	 * Konstruktor
	 * 
	 * @param m
	 *            Man
	 */
	public ManView(Man m) {
		super(m);
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
		//g.setColor(Color.BLUE);
		g.drawImage(man, x, y, null);
	}

	/**
	 * Visszaadja a Man egység sebzés nélküli életét.
	 * 
	 * @return life int - a maximum élet ami lehetséges a Man egységeknél
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeMan;
	}
}
