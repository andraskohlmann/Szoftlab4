package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Elf;

public class ElfView extends EnemyUnitView {

	public ElfView(Elf e) {
		super(e);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

	@Override
	protected int getMaxLife() {
		return Common.lifeElf;
	}
}
