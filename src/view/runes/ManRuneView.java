package view.runes;
import java.awt.Color;
import java.awt.Graphics;

import view.ViewBase;

public class ManRuneView extends ViewBase {
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[]{x + 10, x + 5, x + 15, x + 10} ,new int[]{y + 5, y + 10, y + 10, y + 15} , 4);
	}
}
