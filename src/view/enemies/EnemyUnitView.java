package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.EnemyUnit;
import view.RelativeViewBase;

public abstract class EnemyUnitView implements RelativeViewBase {

	private EnemyUnit enemyUnit;

	public EnemyUnitView(EnemyUnit e) {
		enemyUnit = e;
	}

	protected abstract void setColor(Graphics g);

	protected abstract int getMaxLife();

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
