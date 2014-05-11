package view.enemies;

import java.awt.Graphics;

import model.enemies.Dwarf;

import common.Common;

/**
 * 
 * Dwarf ellens�ges egys�g megjelen�t�s��rt felel�s objektum, lesz�rmazik az
 * EnemyUnitView oszt�lyb�l
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
	 * Az egys�g kirajzol�sa
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordin�ta
	 * @param y
	 * 			  int - y koordin�ta
	 *            
	 */
	@Override
	protected void drawUnit(Graphics g, int x, int y) {
		g.drawImage(dwarf, x, y, null);
	}

	/**
	 * Visszaadja a Dwarf egys�g sebz�s n�lk�li �let�t.
	 * 
	 * @return life int - a maximum �let ami lehets�ges a Dwarf egys�gekn�l
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeDwarf;
	}
}
