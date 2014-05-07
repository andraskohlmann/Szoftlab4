package view.friendly;
import java.awt.Graphics;

import model.friendly.Tower;
import view.ViewBase;
import view.runes.RuneView;

public class TowerView extends ViewBase {
	
	private Tower tower;
	private RuneView runeView;
	
	public void draw(Graphics g) {
		runeView.draw(g);
	}
}
