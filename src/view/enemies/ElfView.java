package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.Elf;

import common.Common;

/**
 * 
 * Elf ellens�ges egys�g megjelen�t�s��rt felel�s objektum, lesz�rmazik az
 * EnemyUnitView oszt�lyb�l
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
	 * A megfelel� sz�nt be�ll�tja a kirajzol�shoz
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

	/**
	 * Visszaadja az Elf egys�g sebz�s n�lk�li �let�t.
	 * 
	 * @return life int - a maximum �let ami lehets�ges az Elf egys�gekn�l
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeElf;
	}
}
