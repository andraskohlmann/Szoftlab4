package view.mapitem;
import java.awt.Graphics;
import java.util.List;

import model.mapitem.Road;
import view.View;
import view.ViewBase;
import view.friendly.SwampView;

public class RoadView extends ViewBase implements View {
	
	private Road road;
	private SwampView swampView;
	private List<ViewBase> enemyUnitViews; 

	public void notifyView() {
	
	}
	
	public void draw(Graphics g) {
		if (needToRepaint) {
			if (swampView != null)
				swampView.draw(g);
			for(ViewBase euv : enemyUnitViews) {
				euv.draw(g);
			}
		}
	}
}