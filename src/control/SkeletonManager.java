package control;

import model.Game;
import model.Ticker;
import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.EnemyUnit;
import model.enemies.Hobbit;
import model.enemies.Man;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Field;
import model.mapitem.Map;
import model.mapitem.Road;
import model.runes.Rune;

public class SkeletonManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Na az a nagy helyzet, hogy ez itt pl egy tipikus szûkös erõforrás
		 * mindenki ide írogat amikor tesztel, így committelésnél csúnyán
		 * összeakadunk. Szóval ha debuggolsz, akk utána töröld ki innen, amit
		 * írtál, vagy mentsd el magadnak vagy valami, a lényeg h a commitban NE
		 * legyen benne.
		 */

		// INNEN A KITÖRLENDÕ KÓD
		// IDÁIG

		SkeletonUI.cleanUp();
	}

	public static void TowerTick(Ticker ticker, Tower t, Game g) {

		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		t.Skeleton_addRune(r);

		Road rd = new Road();
		SkeletonUI.addObject(rd, "rd", true);
		
		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", true);
		
		if (SkeletonUI.booleanQuestion("Do you want a swamp on the road?"))
			rd.Skeleton_SwampSetter(s);

		String answer = SkeletonUI.stringQuestion(
				"What kind of enemy would you create (Dwarf/Elf/Hobbit/Man)?", "D", "E", "H", "M");
		if (answer.equals("D")) {
			Dwarf d = new Dwarf(rd, g);
			SkeletonUI.addObject(d, "d", true);
			t.Skeleton_addUnit(d);
		} else if (answer.equals("E")) {
			Elf e = new Elf();
			SkeletonUI.addObject(e, "e", true);
			t.Skeleton_addUnit(e);
		} else if (answer.equals("H")) {
			Hobbit h = new Hobbit();
			SkeletonUI.addObject(h, "h", true);
			t.Skeleton_addUnit(h);
		} else if (answer.equals("M")) {
			Man m = new Man();
			SkeletonUI.addObject(m, "m", true);
			t.Skeleton_addUnit(m);
		}

		ticker.tick();
	}
	
	public static void SwampTick(Ticker ticker, Swamp s) {
		
		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		s.Skeleton_addRune(r);
		
		String answer = SkeletonUI.stringQuestion(
				"What kind of enemy would you create (Dwarf/Elf/Hobbit/Man)?", "D", "E", "H", "M");
		if (answer.equals("D")) {
			Dwarf d = new Dwarf();
			SkeletonUI.addObject(d, "d", true);
			s.Skeleton_addUnit(d);
		} else if (answer.equals("E")) {
			Elf e = new Elf();
			SkeletonUI.addObject(e, "e", true);
			s.Skeleton_addUnit(e);
		} else if (answer.equals("H")) {
			Hobbit h = new Hobbit();
			SkeletonUI.addObject(h, "h", true);
			s.Skeleton_addUnit(h);
		} else if (answer.equals("M")) {
			Man m = new Man();
			SkeletonUI.addObject(m, "m", true);
			s.Skeleton_addUnit(m);
		}
		
		ticker.tick();
	}
	
	public static void EnemyUnitTick(Ticker ticker, EnemyUnit e) {
		
		Road from = new Road();
		SkeletonUI.addObject(from, "from", true);
		Road to = new Road();
		SkeletonUI.addObject(to, "to", true);
		
		Tower t = new Tower();
		SkeletonUI.addObject(t, "t", true);
		
		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", true);
		
		ticker.tick();
		
	}

	public static void PutRune() {

		Game g = new Game();
		SkeletonUI.addObject(g, "g", true);

		Map m = new Map();
		SkeletonUI.addObject(m, "m", true);

		Field f = new Field();
		SkeletonUI.addObject(f, "f", true);

		Road r = new Road();
		SkeletonUI.addObject(r, "r", true);

		Tower t = new Tower();
		SkeletonUI.addObject(t, "t", true);

		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", true);

		g.Skeleton_MapSetter(m);

		m.Skeleton_FieldSetter(f);
		m.Skeleton_RoadSetter(r);

		f.Skeleton_TowerSetter(t);
		r.Skeleton_SwampSetter(s);

		g.Skeleton_MouseOnTile_Rune();
	}

	public static void PutSwamp() {
		Game g = new Game();
		SkeletonUI.addObject(g, "g", true);

		Map m = new Map();
		SkeletonUI.addObject(m, "m", true);
		g.Skeleton_MapSetter(m);

		Field f = new Field();
		SkeletonUI.addObject(f, "f", true);
		m.Skeleton_FieldSetter(f);

		Road r = new Road();
		SkeletonUI.addObject(r, "r", true);
		m.Skeleton_RoadSetter(r);

		g.Skeleton_MouseOnTile_Swamp();
	}

}
