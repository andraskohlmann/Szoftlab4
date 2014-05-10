package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Dwarf;

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
	 * A megfelelõ színt beállítja a kirajzoláshoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.BLUE);
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
