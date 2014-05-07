package view;

import model.mapitem.Field;
import model.mapitem.FinishedRoad;
import model.mapitem.Road;
import view.mapitem.FieldView;
import view.mapitem.FinishedRoadView;
import view.mapitem.RoadView;
import view.mapitem.TileView;

public class ViewFactory {

	public static TileView createView(Road r, int x, int y) {
		return new RoadView(r, x, y);
	}

	public static TileView createView(Field f, int x, int y) {
		return new FieldView(f, x, y);
	}

	public static ViewBase createView(FinishedRoad f, int x, int y) {
		return new FinishedRoadView(x, y);
	}

}
