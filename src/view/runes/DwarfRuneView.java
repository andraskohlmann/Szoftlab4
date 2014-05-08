package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.DwarfRune;

public class DwarfRuneView extends RuneView {
	
	public DwarfRuneView(DwarfRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.BLACK);
	}

	
}
