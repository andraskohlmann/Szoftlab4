package model;

import java.util.List;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.EnemyUnit;
import model.enemies.Hobbit;
import model.enemies.Man;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Map;
import model.runes.Rune;
import control.SkeletonUI;

public class Game {

	private Map map;

	private Ticker ticker;

	public void putTower(int x, int y)
	{
		
	}
	
	
	public void Skeleton_MapSetter(Map m) {
		map = m;
	}

	public void tick() {
		ticker.tick();
		
		// TODO: beértek elkérése
	}

	public void notifyIfDead(EnemyUnit e) {
		ticker.remove(e);
	}

	public void Skeleton_MouseOnTile_Rune() {
		boolean available = map.checkRune(0, 0);

		if (available) {

			Rune rune = new Rune();
			SkeletonUI.addObject(rune, "rune", true);

			map.putRune(0, 0, rune);
		}
	}

	public void Skeleton_MouseOnTile_Swamp() {
		boolean available = map.checkSwamp(0, 0);
		if (available) {
			Rune r = new Rune();
			SkeletonUI.addObject(r, "r", true);

			Swamp s = new Swamp();
			SkeletonUI.addObject(s, "s", true);

			map.putSwamp(0, 0, s);
			map.putRune(0, 0, r);

		}

	}

	public void Skeleton_MouseOnTile_Tower() {
		boolean available = map.checkTower(0, 0);
		if (available) {
			Rune r = new Rune();
			SkeletonUI.addObject(r, "r", true);

			Tower t = new Tower();
			SkeletonUI.addObject(t, "t", true);

			map.putTower(0, 0, t);
			map.putRune(0, 0, r);

		}

	}

	public void Skeleton_addTicker(Ticker t) {
		ticker = t;
	}

	public void Skeleton_tick_FirstSegment() {
		SkeletonUI.enterFunction(this, "tick");

		EnemyUnit e = null;

		String answer = SkeletonUI
				.stringQuestion(
						"Do you want any kind of enemy to enter the game? (Dwarf/Elf/Hobbit/Man/Nop)?",
						"D", "E", "H", "M", "N");
		if (answer.equals("D")) {
			e = new Dwarf(this);
			SkeletonUI.addObject(e, "e", true);
			ticker.Skeleton_remove(e);
		} else if (answer.equals("E")) {
			e = new Elf(this);
			SkeletonUI.addObject(e, "e", true);
		} else if (answer.equals("H")) {
			e = new Hobbit(this);
			SkeletonUI.addObject(e, "e", true);
		} else if (answer.equals("M")) {
			e = new Man(this);
			SkeletonUI.addObject(e, "e", true);
		}

		if (!answer.equals("N")) {
			map.addUnit(e);
			ticker.addUnit(e);
			ticker.Skeleton_remove(e);
		}

	}

	public void Skeleton_tick_SecondSegment() {

		List<EnemyUnit> unitList = map.getFinishedUnits();

		map.deleteFinishedUnits();

		ticker.remove(unitList);

		SkeletonUI.leaveFunction();
	}

	public void loadMap(String filename) {
		// TODO Auto-generated method stub
		
	}
}
