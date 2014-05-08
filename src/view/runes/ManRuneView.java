package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ManRune;

public class ManRuneView extends RuneView {
	
	public ManRuneView(ManRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.WHITE);
	}

}
