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
import model.mapitem.FinishedRoad;
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

	public static void menu() {
		boolean isLoop = true;

		while (isLoop) {
			switch (SkeletonUI.menuQuestion("What do you want to do?",
					"start Game Tick sequence", "start Put Rune sequence",
					"start Put Swamp sequence", "start Put Tower sequence",
					"quit skeleton")) {
			case 1:
				GameTick();
				break;
			case 2:
				PutRune();
				break;
			case 3:
				PutSwamp();
				break;
			case 4:
				PutTower();
				break;
			case 5:
				isLoop = false;
				break;
			}
		}

	}

	public static void GameTick() {

		Game g = new Game();
		SkeletonUI.addObject(g, "g", true);

		Map m = new Map();
		SkeletonUI.addObject(m, "m", true);

		Road r = new Road();
		SkeletonUI.addObject(r, "r", true);

		Ticker ticker = new Ticker();
		SkeletonUI.addObject(ticker, "ticker", true);

		Tower t = new Tower();
		SkeletonUI.addObject(t, "t", false);

		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", false);

		g.Skeleton_MapSetter(m);
		g.Skeleton_addTicker(ticker);
		m.Skeleton_RoadSetter(r);
		r.Skeleton_SwampSetter(s);
		r.Skeleton_addTower(t);

		g.Skeleton_tick_FirstSegment();

		if (SkeletonUI
				.booleanQuestion("Do you want to enter the tower tick sequence?")) {
			ticker.Skeleton_addUnit(t);
			TowerTick(ticker, t, g);
			ticker.Skeleton_remove(t);
		}

		if (SkeletonUI
				.booleanQuestion("Do you want to enter the swamp tick sequence?")) {
			ticker.Skeleton_addUnit(s);
			SwampTick(ticker, s);
			ticker.Skeleton_remove(s);
		}

		EnemyUnit e = null;

		String answer = SkeletonUI
				.stringQuestion(
						"Are there any kind of enemies for the enemyunit tick sequence\n (Dwarf/Elf/Hobbit/Man/Nop)?",
						"D", "E", "H", "M", "N");
		if (answer.equals("D")) {
			e = new Dwarf(g);
			SkeletonUI.addObject(e, "e", false);
		} else if (answer.equals("E")) {
			e = new Elf(g);
			SkeletonUI.addObject(e, "e", false);
		} else if (answer.equals("H")) {
			e = new Hobbit(g);
			SkeletonUI.addObject(e, "e", false);
		} else if (answer.equals("M")) {
			e = new Man(g);
			SkeletonUI.addObject(e, "e", false);
		}

		if (!answer.equals("N")) {
			ticker.addUnit(e);
			EnemyUnitTick(ticker, e);
			ticker.Skeleton_remove(e);
		}

		m.Skeleton_FinishedRoadSetter(new FinishedRoad());

		g.Skeleton_tick_SecondSegment();

	}

	public static void TowerTick(Ticker ticker, Tower t, Game g) {

		// Ezeknek a kreálásánál biztos, hogy mindnél szükséges
		// a loud = true? Szerintem nem - Kohlmann
		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		t.Skeleton_addRune(r);

		Road rd = new Road();
		SkeletonUI.addObject(rd, "rd", true);

		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", true);

		// Szerintem ez a kérdés, és a swamp beállítás itt tök fölösleges -
		// Kohlmann
		if (SkeletonUI.booleanQuestion("Do you want a swamp on the road?"))
			rd.Skeleton_SwampSetter(s);

		// Itt mondjuk lehetne egy értelmes kérdés - Kohlmann
		String answer = SkeletonUI.stringQuestion(
				"What kind of enemy would you create (Dwarf/Elf/Hobbit/Man)?",
				"D", "E", "H", "M");
		if (answer.equals("D")) {
			Dwarf d = new Dwarf(rd, g);
			SkeletonUI.addObject(d, "d", true);
			t.Skeleton_addUnit(d);
		} else if (answer.equals("E")) {
			Elf e = new Elf(rd, g);
			SkeletonUI.addObject(e, "e", true);
			t.Skeleton_addUnit(e);
		} else if (answer.equals("H")) {
			Hobbit h = new Hobbit(rd, g);
			SkeletonUI.addObject(h, "h", true);
			t.Skeleton_addUnit(h);
		} else if (answer.equals("M")) {
			Man m = new Man(rd, g);
			SkeletonUI.addObject(m, "m", true);
			t.Skeleton_addUnit(m);
		}

		ticker.tick();
	}

	public static void SwampTick(Ticker ticker, Swamp s) {

		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		s.Skeleton_addRune(r);

		// Szintén, ide is értelmes kérdés kéne - Kohlmann
		String answer = SkeletonUI.stringQuestion(
				"What kind of enemy would you create (Dwarf/Elf/Hobbit/Man)?",
				"D", "E", "H", "M");
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
		from.Skeleton_addNextRoad(to);

		// Innen utólagos engedéllyel kiszedtem a ticker.Skeleton_addUnit(e)-t
		// mert már ilyen állapotban kapja a paramétereket a gameticktõl -
		// Kohlmann
		e.setRoad(from);

		// Ezek szerintem nem loud=true-k - Kohlmann
		Tower t = new Tower();
		SkeletonUI.addObject(t, "t", true);

		Swamp s = new Swamp();
		SkeletonUI.addObject(s, "s", true);

		// Is* - grammar nazi out - Kohlmann
		if (SkeletonUI.booleanQuestion("Are there a swamp on the road?")) {
			from.Skeleton_SwampSetter(s);
			// Itt még csak a fromnak kell odaadni a swampot, a to-ra majd
			// késõbb kérdezel rá, hogy van e ott swamp - Kohlmann
			to.Skeleton_SwampSetter(s);
		}

		/*
		 * Itt kell megkérdezni azt, hogy van-e tower ugyanúgy ahogy a komment
		 * felett megkérdezed, hogy van-e swamp.
		 * 
		 * És attól függõen skeletonsetterrel odaadod a fromnak a towert és a
		 * towerbe skeletonsetterrel beleteszed az e-t
		 * 
		 * - Kohlmann
		 */

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

	public static void PutTower() {
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

		g.Skeleton_MouseOnTile_Tower();
	}

}
