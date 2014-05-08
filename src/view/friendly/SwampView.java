package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Swamp;
import view.RelativeViewBase;
import view.runes.RuneView;

public class SwampView implements RelativeViewBase {

	private RuneView runeView;
	private Swamp swamp;

	public SwampView(Swamp s) {
		swamp = s;
		runeView = new RuneView();
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 2, 16, 16);
		runeView.draw(g, x , y);
	}
}
