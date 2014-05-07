package view.enemies;
import java.awt.Graphics;

import model.enemies.Dwarf;
import view.ViewBase;

public class DwarfView extends ViewBase {
	
	private Dwarf dwarf;
	
	public void draw(Graphics g) {
		int health = dwarf.getParameters();
	}
}
