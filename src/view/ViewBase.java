package view;

import java.awt.Graphics;

public abstract class ViewBase {

	protected int x;
	protected int y;

	public ViewBase() {

	}

	public ViewBase(int x, int y) {
		this.x = x*20;
		this.y = y*20;
	}

	public abstract void draw(Graphics g);

	// public void draw(Graphics g, int x, int y) {}
}
