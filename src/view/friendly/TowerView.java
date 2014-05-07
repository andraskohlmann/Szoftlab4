package view.friendly;
import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Tower;
import view.ViewBase;
import view.runes.RuneView;

public class TowerView extends ViewBase {
	
	private Tower tower;
	private RuneView runeView;
	
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval(x + 2, y + 2, 16, 16);
		runeView.draw(g);
	}
}
