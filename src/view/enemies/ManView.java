package view.enemies;

import java.awt.Color;
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
	 * A megfelelõ színt beállítja a kirajzoláshoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.PINK);
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
