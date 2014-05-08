package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Elf;
import view.RelativeViewBase;

public class ElfView implements RelativeViewBase {

	private Elf elf;

	public ElfView(Elf e) {
		elf = e;
	}

	public void draw(Graphics g, int x, int y) {
		int health = elf.getParameters();

		g.setColor(Color.WHITE);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / Common.lifeElf), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
