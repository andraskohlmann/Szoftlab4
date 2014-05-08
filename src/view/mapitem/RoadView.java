package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.enemies.EnemyUnit;
import model.mapitem.Road;
import view.RelativeViewBase;
import view.friendly.SwampView;

public class RoadView extends TileViewBase {

	private Road road;

	private RelativeViewBase swampView;

	public RoadView(Road r, int x, int y) {
		super(x, y);

		road = r;
	}

	public void notifyView() {
		if (swampView == null && road.hasSwamp()) {
			swampView = new SwampView(road.getSwamp());
		}

		super.notifyView();
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x * 20, y * 20, 20, 20);

		if (swampView != null)
			swampView.draw(g, x * 20, y * 20);
		for (EnemyUnit eu : road.getEnemyList()) {
			((RelativeViewBase) eu.getView()).draw(g, x * 20, y * 20);
		}
	}

}