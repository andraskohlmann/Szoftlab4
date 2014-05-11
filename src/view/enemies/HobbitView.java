package view.enemies;

import java.awt.Color;
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
	 * A megfelel� sz�nt be�ll�tja a kirajzol�shoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
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
