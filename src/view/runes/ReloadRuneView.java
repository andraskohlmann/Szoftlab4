package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.ReloadRune;

public class ReloadRuneView extends RuneView {

	public ReloadRuneView(ReloadRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.MAGENTA);
	}

}
