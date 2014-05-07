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

	private boolean needToRepaint;

	public FieldView(Field f) {
		field = f;

		needToRepaint = true;
	}

	public void notifyView() {
		if (towerView == null && field.hasTower()) {
			towerView = new TowerView(field.getTower());
		}
		
		needToRepaint = true;
	}

	public void draw(Graphics g) {
		if (needToRepaint) {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 20, 20);
			
			if (towerView != null)
				towerView.draw(g);
			
			if (fogView != null)
				fogView.draw(g);
			
			needToRepaint = false;
		}
	}
}
