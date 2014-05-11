package view.enemies;

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
		g.drawImage(elf, x, y, null);
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
