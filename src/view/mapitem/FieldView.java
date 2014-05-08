package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.mapitem.Field;
import view.RelativeViewBase;

public class FieldView extends TileViewBase {

	private Field field;

	public FieldView(Field f, int x, int y) {
		super(x, y);

		field = f;
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x * 20, y * 20, 20, 20);
		
		if (field.hasTower()) {
			((RelativeViewBase) field.getTower().getView()).draw(g, x * 20, y * 20);
		}
		
		if (field.hasFog()) {
			((RelativeViewBase) field.getFog().getView()).draw(g, x * 20, y * 20);
		}
	}
}
