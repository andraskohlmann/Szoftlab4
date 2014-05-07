package view;

import java.awt.Graphics;

public abstract class ViewBase {

	protected int x;
	protected int y;
	
	public ViewBase() {
		
	}
	
	public ViewBase(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void draw(Graphics g);
}
