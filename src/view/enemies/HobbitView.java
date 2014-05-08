package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Hobbit;
import view.RelativeViewBase;

public class HobbitView implements RelativeViewBase {

	private Hobbit hobbit;

	public HobbitView(Hobbit h) {
		hobbit = h;
	}

	public void draw(Graphics g, int x, int y) {
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
