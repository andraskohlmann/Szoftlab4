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
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / getMaxLife()), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
