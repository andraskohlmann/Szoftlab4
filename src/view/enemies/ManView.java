package view.enemies;

import java.awt.Graphics;

import model.enemies.Man;

import common.Common;

/**
 * 
 * Man ellens�ges egys�g megjelen�t�s��rt felel�s objektum, lesz�rmazik az
 * EnemyUnitView oszt�lyb�l
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
		//g.setColor(Color.BLUE);
		g.drawImage(man, x, y, null);
	}

	/**
	 * Visszaadja a Man egys�g sebz�s n�lk�li �let�t.
	 * 
	 * @return life int - a maximum �let ami lehets�ges a Man egys�gekn�l
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeMan;
	}
}
