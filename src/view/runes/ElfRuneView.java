package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ElfRune;

public class ElfRuneView extends RuneView {
	
	public ElfRuneView(ElfRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.GREEN);
	}

}
