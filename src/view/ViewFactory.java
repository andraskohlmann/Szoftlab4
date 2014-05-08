package view;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;
import model.mapitem.Field;
import model.mapitem.FinishedRoad;
import model.mapitem.Road;
import view.enemies.DwarfView;
import view.enemies.ElfView;
import view.enemies.HobbitView;
import view.enemies.ManView;
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
	
	public static Object createView(Dwarf d) {
		return new DwarfView(d);
	}
	
	public static Object createView(Elf e) {
		return new ElfView(e);
	}
	
	public static Object createView(Hobbit h) {
		return new HobbitView(h);
	}
	
	public static Object createView(Man m) {
		return new ManView(m);
	}

}
