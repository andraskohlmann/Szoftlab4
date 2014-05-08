package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.RangeRune;

public class RangeRuneView extends RuneView {

	public RangeRuneView(RangeRune r) {
		super(r);
	}

	@Override
	protected void setColor(Graphics g) {
		g.setColor(Color.CYAN);
	}

}
