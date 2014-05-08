package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Dwarf;

public class DwarfView extends EnemyUnitView {

	public DwarfView(Dwarf d) {
		super(d);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.BLUE);
	}

	@Override
	protected int getMaxLife() {
		return Common.lifeDwarf;
	}
}
