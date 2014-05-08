package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Man;

public class ManView extends EnemyUnitView {

	public ManView(Man m) {
		super(m);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.PINK);
	}

	@Override
	protected int getMaxLife() {
		return Common.lifeMan;
	}
}
