package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Tower;
import view.RelativeViewBase;

public class TowerView implements RelativeViewBase {

	private Tower tower;

	public TowerView(Tower t) {
		tower = t;
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.GRAY);
		g.fillOval(x + 2, y + 2, 16, 16);
		
		((RelativeViewBase) tower.getRune().getView()).draw(g, x, y);
	}
}
