package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Hobbit;
import view.ViewBase;

public class HobbitView extends ViewBase {

	private Hobbit hobbit;

	public void draw(Graphics g) {
		int health = hobbit.getParameters();

		g.setColor(Color.CYAN);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / Common.lifeHobbit),
				3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
