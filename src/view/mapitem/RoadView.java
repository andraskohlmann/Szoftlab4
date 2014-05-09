package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.EnemyUnit;
import model.mapitem.Road;
import view.RelativeViewBase;

public class RoadView extends TileViewBase {

	private Road road;

	public RoadView(Road r, int x, int y) {
		super(x, y);

		road = r;
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, Common.tileWidth, Common.tileWidth);

		if (road.hasSwamp()) {
			((RelativeViewBase) road.getSwamp().getView()).draw(g, x, y);
		}
		for (EnemyUnit eu : road.getEnemyList()) {
			((RelativeViewBase) eu.getView()).draw(g, x, y);
		}
	}

}