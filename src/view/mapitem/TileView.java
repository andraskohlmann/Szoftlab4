package view.mapitem;

import java.awt.Graphics;

import view.View;
import view.ViewBase;

public abstract class TileView extends ViewBase implements View {

	private boolean needToRepaint;

	public TileView(int x, int y) {
		super(x, y);

		needToRepaint = true;
	}

	@Override
	public void notifyView() {
		needToRepaint = true;
	}

	@Override
	public void draw(Graphics g) {
		if (needToRepaint) {
			paintMe(g);

			needToRepaint = false;
		}
	}

	protected abstract void paintMe(Graphics g);

}
