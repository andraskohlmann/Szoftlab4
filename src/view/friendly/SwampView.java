package view.friendly;

import java.awt.Graphics;

import model.friendly.Swamp;

import view.ViewBase;
import view.runes.RuneView;

public class SwampView extends ViewBase {

	private RuneView runeView;
	private Swamp swamp;

	public SwampView(Swamp s) {
		swamp = s;
	}

	public void draw(Graphics g) {
		runeView.draw(g);
	}
}
