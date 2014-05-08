package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import model.mapitem.Road;
import view.ViewBase;
import view.friendly.SwampView;

public class RoadView extends TileViewBase {

	private Road road;
	private SwampView swampView;
	private List<ViewBase> enemyUnitViews;

	public RoadView(Road r, int x, int y) {
		super(x, y);

		road = r;
		enemyUnitViews = new ArrayList<ViewBase>();
	}

	public void notifyView() {
		if (swampView == null && road.hasSwamp()) {
			swampView = new SwampView(road.getSwamp(), x, y);
		}

		super.notifyView();
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x * 20, y * 20, 20, 20);

		if (swampView != null)
			swampView.draw(g);
		for (ViewBase euv : enemyUnitViews) {
			euv.draw(g);
		}
	}

}