package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;

import view.ViewBase;

public class FinishedRoadView extends ViewBase {

	public FinishedRoadView(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, Common.tileWidth, Common.tileWidth);
	}
}
