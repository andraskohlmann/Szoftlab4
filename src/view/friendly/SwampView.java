package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Swamp;
import view.ViewBase;
import view.runes.RuneView;

public class SwampView extends ViewBase {

	private RuneView runeView;
	private Swamp swamp;

	public SwampView(Swamp s, int x, int y) {
		super(x, y);

		swamp = s;
		runeView = new RuneView(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 2, 16, 16);
		runeView.draw(g);
	}
}
