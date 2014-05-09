package view;

import java.awt.Graphics;

import model.Common;

public abstract class ViewBase {

	protected int x;
	protected int y;

	public ViewBase(int x, int y) {
		this.x = x * Common.tileWidth;
		this.y = y * Common.tileWidth;
	}

	public abstract void draw(Graphics g);
}
