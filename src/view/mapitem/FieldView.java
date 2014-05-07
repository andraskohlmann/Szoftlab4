package view.mapitem;
import java.awt.Color;
import java.awt.Graphics;

import model.mapitem.Field;
import view.View;
import view.ViewBase;
import view.friendly.TowerView;

public class FieldView extends ViewBase implements View {
	
	private Field field;
	private TowerView towerView;
	private FogView fogView;
	
	public FieldView(Field f) {
		field = f;
	}

	public void notifyView() {
	
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x, y, 20, 20);
		if(towerView != null)
			towerView.draw(g);
		if(fogView != null)
			fogView.draw(g);
	}
}
