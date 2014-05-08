package view;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Field;
import model.mapitem.FinishedRoad;
import model.mapitem.Fog;
import model.mapitem.Road;
import model.runes.DwarfRune;
import model.runes.ElfRune;
import model.runes.HobbitRune;
import model.runes.ManRune;
import model.runes.RangeRune;
import model.runes.ReloadRune;
import model.runes.Rune;
import view.enemies.DwarfView;
import view.enemies.ElfView;
import view.enemies.HobbitView;
import view.enemies.ManView;
import view.friendly.SwampView;
import view.friendly.TowerView;
import view.mapitem.FieldView;
import view.mapitem.FinishedRoadView;
import view.mapitem.FogView;
import view.mapitem.RoadView;
import view.mapitem.TileViewBase;
import view.runes.DwarfRuneView;
import view.runes.ElfRuneView;
import view.runes.HobbitRuneView;
import view.runes.ManRuneView;
import view.runes.RangeRuneView;
import view.runes.ReloadRuneView;
import view.runes.RuneView;

public class ViewFactory {

	//////////////////////////////////////////////////////////////
	// MAPITEMS
	
	public static TileViewBase createView(Road r, int x, int y) {
		return new RoadView(r, x, y);
	}

	public static TileViewBase createView(Field f, int x, int y) {
		return new FieldView(f, x, y);
	}

	public static ViewBase createView(FinishedRoad f, int x, int y) {
		return new FinishedRoadView(x, y);
	}
	
	///////////////////////////////////////////////////////////////
	// ENEMY UNITS
	
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
	
	////////////////////////////////////////////////////////////////
	// FRIENDLY + FOG
	
	public static Object createView(Fog f) {
		return new FogView();
	}
	
	public static Object createView(Swamp s) {
		return new SwampView(s);
	}
	
	public static Object createView(Tower t) {
		return new TowerView(t);
	}
	
	/////////////////////////////////////////////////////////////////
	// RUNES
	
	public static Object createView(Rune r) {
		return new RuneView(r);
	}
	
	public static Object createView(DwarfRune r) {
		return new DwarfRuneView(r);
	}
	
	public static Object createView(ElfRune r) {
		return new ElfRuneView(r);
	}
	
	public static Object createView(HobbitRune r) {
		return new HobbitRuneView(r);
	}
	
	public static Object createView(ManRune r) {
		return new ManRuneView(r);
	}
	
	public static Object createView(RangeRune r) {
		return new RangeRuneView(r);
	}
	
	public static Object createView(ReloadRune r) {
		return new ReloadRuneView(r);
	}

}
