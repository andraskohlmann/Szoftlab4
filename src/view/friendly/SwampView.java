package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Swamp;
import view.RelativeViewBase;

public class SwampView implements RelativeViewBase {

	private Swamp swamp;

	public SwampView(Swamp s) {
		swamp = s;
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 2, 16, 16);
		
		((RelativeViewBase)swamp.getRune().getView()).draw(g, x, y);
	}
}
