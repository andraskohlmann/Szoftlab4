package view.mapitem;
import java.awt.Graphics;

import model.mapitem.Field;
import view.View;
import view.ViewBase;
import view.friendly.TowerView;

public class FieldView extends ViewBase implements View {
	
	private Field field;
	private TowerView towerview;
	private FogView fogview;
	
	public void notifyView() {
	
	}
	
	public void draw(Graphics g) {
	
	}
}
