package view;

import model.mapitem.Field;
import model.mapitem.FinishedRoad;
import model.mapitem.Road;
import view.mapitem.FieldView;
import view.mapitem.FinishedRoadView;
import view.mapitem.RoadView;
import view.mapitem.TileView;

public class ViewFactory {
	
	public static TileView createView(Road r){
		return new RoadView(r);
	}
	
	public static TileView createView(Field f){
		return new FieldView(f);
	}
	
	public static ViewBase createView(FinishedRoad f){
		return new FinishedRoadView();
	}

}
