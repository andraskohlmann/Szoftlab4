package view.enemies;

import java.awt.Graphics;

import model.enemies.Hobbit;

import common.Common;

/**
 * 
 * Hobbit ellens�ges egys�g megjelen�t�s��rt felel�s objektum, lesz�rmazik az
 * EnemyUnitView oszt�lyb�l
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
		g.drawImage(hobbit, x, y, null);
	}
	
	/**
	 * Visszaadja a Hobbit egys�g sebz�s n�lk�li �let�t.
	 * 
	 * @return life int - a maximum �let ami lehets�ges a Hobbit egys�gekn�l
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeHobbit;
	}
}
