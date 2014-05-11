package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.Elf;

import common.Common;

/**
 * 
 * Elf ellenséges egység megjelenítéséért felelõs objektum, leszármazik az
 * EnemyUnitView osztályból
 * 
 */
public class ElfView extends EnemyUnitView {
	/**
	 * Konstruktor
	 * 
	 * @param e
	 *            Elf
	 */
	public ElfView(Elf e) {
		super(e);
	}

	/**
	 * A megfelelõ színt beállítja a kirajzoláshoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

	/**
	 * Visszaadja az Elf egység sebzés nélküli életét.
	 * 
	 * @return life int - a maximum élet ami lehetséges az Elf egységeknél
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeElf;
	}
}
