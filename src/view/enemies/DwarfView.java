package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Dwarf;
import view.ViewBase;

public class DwarfView extends ViewBase {

	private Dwarf dwarf;

	public void draw(Graphics g) {
		int health = dwarf.getParameters();

		g.setColor(Color.BLUE);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / Common.lifeDwarf), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
