package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import model.mapitem.Road;
import view.ViewBase;
import view.friendly.SwampView;

public class RoadView extends TileView {

	private Road road;
	private SwampView swampView;
	private List<ViewBase> enemyUnitViews;

	public RoadView(Road r) {
		road = r;
	}

	public void notifyView() {

	}

	protected void paintMe(Graphics g) {
		if (swampView != null)
			swampView.draw(g);
		for (ViewBase euv : enemyUnitViews) {
			euv.draw(g);
		}
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 20, 20);
	}

}