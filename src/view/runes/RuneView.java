package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import view.ViewBase;

public class RuneView extends ViewBase {

	public RuneView(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillPolygon(new int[] { x*20 + 5, x*20 + 10, x*20 + 15, x*20 + 10 }, new int[] {
				y*20 + 10, y*20 + 15, y*20 + 10, y*20 + 5 }, 4);
	}
}
