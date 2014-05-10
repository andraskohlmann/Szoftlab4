package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.EnemyUnit;
import view.RelativeViewBase;

/**
 * 
 * Általános EnemyUnitView osztály mely felelõssége a különbözõ játékban
 * szereplõ ellenséges egységek megjelenítésének menedzselése.
 * 
 */
public abstract class EnemyUnitView implements RelativeViewBase {
	/**
	 * Kirajzolandó ellenséges egység
	 */
	private EnemyUnit enemyUnit;

	/**
	 * Konstruktor
	 * 
	 * @param e
	 *            EnemyUnit
	 */
	public EnemyUnitView(EnemyUnit e) {
		enemyUnit = e;
	}

	/**
	 * Abstract metódus a kirajzolás színének beállítására
	 * 
	 * @param g
	 *            Graphics
	 */
	protected abstract void setColor(Graphics g);

	/**
	 * Abstract metódus az egyes egységek maximum életének lekérdezésére
	 * 
	 * @return
	 */
	protected abstract int getMaxLife();

	/**
	 * Az egyes ellenséges egységek kirajzolásáért felelõs függvény, valamint az
	 * egységek életét megjelenítõ kis csík kirajzolását is végzi.
	 * 
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 * @param g
	 *            Graphics -
	 */
	public final void draw(Graphics g, int x, int y) {
		int health = enemyUnit.getParameters();

		setColor(g);
		g.fillOval(x + 5, y + 6, 10, 10);
		g.setColor(Color.GREEN);
		g.fillRect(x + 5, y + 1, (int) (10 * (double) health / getMaxLife()), 3);
		g.setColor(Color.RED);
		g.fillRect(x + 15
				- (int) (10 * (double) (getMaxLife() - health) / getMaxLife()),
				y + 1,
				(int) (10 * (double) (getMaxLife() - health) / getMaxLife()), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x + 5, y + 1, 10, 3);
	}
}
