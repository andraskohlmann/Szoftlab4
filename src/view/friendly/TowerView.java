package view.friendly;
import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Tower;
import view.ViewBase;
import view.runes.RuneView;

public class TowerView extends ViewBase {
	
	private Tower tower;
	private RuneView runeView;
	
	public TowerView(Tower t, int x, int y) {
		super(x, y);
		
		tower = t;
		
		runeView = new RuneView(x, y);
	}

	public void draw(Graphics g) {
		
		System.out.println("tower draw " + x + " " + y);
		g.setColor(Color.GRAY);
		g.fillOval(x * 20 + 2, y * 20 + 2 , 16, 16);
		runeView.draw(g);
	}
}
