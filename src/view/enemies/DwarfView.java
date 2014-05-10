package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Dwarf;

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
	 * A megfelel� sz�nt be�ll�tja a kirajzol�shoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.BLUE);
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
