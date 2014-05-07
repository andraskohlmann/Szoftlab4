package view;

import view.mapitem.RoadView;

public class ViewFactory {
	
	public static ViewBase createView(Object o){
		return new RoadView();
	}

}
