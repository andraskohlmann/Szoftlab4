package view.enemies;

import java.awt.Graphics;

import model.enemies.Man;
import view.ViewBase;

public class ManView extends ViewBase {
	
	private Man man;
	
	public void draw(Graphics g) {
		int health = man.getParameters();
	}
}
