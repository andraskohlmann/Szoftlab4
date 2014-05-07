package view.enemies;

import java.awt.Graphics;

import model.enemies.Hobbit;
import view.ViewBase;

public class HobbitView extends ViewBase {
	
	private Hobbit hobbit;
	
	public void draw(Graphics g) {
		int health = hobbit.getParameters();
	}
}
