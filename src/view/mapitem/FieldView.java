package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.mapitem.Field;
import view.ViewBase;
import view.friendly.TowerView;

public class FieldView extends TileView {

	private Field field;
	private ViewBase towerView;
	private ViewBase fogView;

	public FieldView(Field f, int x, int y) {
		super(x, y);
		
		field = f;
	}

	public void notifyView() {
		if (towerView == null && field.hasTower()) {
			towerView = new TowerView(field.getTower(), x, y);
		}
		
		if (fogView == null && field.hasFog()) {
			fogView = new FogView();
		} else if (fogView != null && !field.hasFog()) {
			fogView = null;
		}

		super.notifyView();
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x*20, y*20, 20, 20);

		if (towerView != null)
			towerView.draw(g);

		if (fogView != null)
			fogView.draw(g);
	}
}
