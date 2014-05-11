package view.enemies;

import java.awt.Color;
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
	 * A megfelel� sz�nt be�ll�tja a kirajzol�shoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.PINK);
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
