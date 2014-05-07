package view.friendly;
import java.awt.Graphics;

import view.ViewBase;
import view.runes.RuneView;

public class SwampView extends ViewBase {
	
	private RuneView runeView;
	
	public void draw(Graphics g) {
		runeView.draw(g);
	}
}
