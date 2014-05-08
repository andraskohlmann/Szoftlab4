package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.HobbitRune;

public class HobbitRuneView extends RuneView {
		
	public HobbitRuneView(HobbitRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.ORANGE);
	}

}
