package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Tower;
import view.RelativeViewBase;
import view.runes.RuneView;

public class TowerView implements RelativeViewBase {

	private Tower tower;
	private RuneView runeView;

	public TowerView(Tower t) {
		tower = t;

		runeView = new RuneView();
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.GRAY);
		g.fillOval(x + 2, y + 2, 16, 16);
		runeView.draw(g, x, y);
	}
}
