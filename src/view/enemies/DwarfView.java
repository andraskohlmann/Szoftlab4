package view.enemies;

import java.awt.Graphics;

import model.enemies.Dwarf;

import common.Common;

/**
 * 
 * Dwarf ellenséges egység megjelenítéséért felelõs objektum, leszármazik az
 * EnemyUnitView osztályból
 * 
 */
public class DwarfView extends EnemyUnitView {
	/**
	 * Konstruktor
	 * 
	 * @param d
	 *            Dwarf
	 */
	public DwarfView(Dwarf d) {
		super(d);
		
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
		g.drawImage(dwarf, x, y, null);
	}

	/**
	 * Visszaadja a Dwarf egység sebzés nélküli életét.
	 * 
	 * @return life int - a maximum élet ami lehetséges a Dwarf egységeknél
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeDwarf;
	}
}
