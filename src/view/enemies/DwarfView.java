package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Dwarf;
import view.RelativeViewBase;

public class DwarfView implements RelativeViewBase {

	private Dwarf dwarf;

	public DwarfView(Dwarf d) {
		dwarf = d;
	}

	public void draw(Graphics g, int x, int y) {
		int health = dwarf.getParameters();

		g.setColor(Color.BLUE);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / Common.lifeDwarf), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
