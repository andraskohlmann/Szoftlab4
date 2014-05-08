package view;

import model.mapitem.Field;
import model.mapitem.FinishedRoad;
import model.mapitem.Road;
import view.mapitem.FieldView;
import view.mapitem.FinishedRoadView;
import view.mapitem.RoadView;
import view.mapitem.TileViewBase;

public class ViewFactory {

	public static TileViewBase createView(Road r, int x, int y) {
		return new RoadView(r, x, y);
	}

	public static TileViewBase createView(Field f, int x, int y) {
		return new FieldView(f, x, y);
	}

	public static ViewBase createView(FinishedRoad f, int x, int y) {
		return new FinishedRoadView(x, y);
	}

}
