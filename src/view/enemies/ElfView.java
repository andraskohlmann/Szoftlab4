package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.Elf;
import view.ViewBase;

public class ElfView extends ViewBase {
	
	private Elf elf;
	
	public void draw(Graphics g) {
		int health = elf.getParameters();
		
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
