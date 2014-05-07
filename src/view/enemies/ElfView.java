package view.enemies;

import java.awt.Graphics;

import model.enemies.Elf;
import view.ViewBase;

public class ElfView extends ViewBase {
	
	private Elf elf;
	
	public void draw(Graphics g) {
		int health = elf.getParameters();
	}
}
