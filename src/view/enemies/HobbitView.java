package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Hobbit;

public class HobbitView extends EnemyUnitView {

	public HobbitView(Hobbit h) {
		super(h);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
	}

	@Override
	protected int getMaxLife() {
		return Common.lifeHobbit;
	}
}
