package model;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Fog;
import model.mapitem.Map;
import model.runes.DwarfRune;
import model.runes.ElfRune;
import model.runes.HobbitRune;
import model.runes.ManRune;
import model.runes.RangeRune;
import model.runes.ReloadRune;
import model.runes.Rune;
import control.RuneType;

public class Game {

	private Map map;
	private Ticker ticker;

	private int life = Common.life;
	private int magitzka = Common.start_mTz;

	public int getLife() {
		return life;
	}

	public int getMagitzka() {
		return magitzka;
	}

	public Map getMap() {
		return map;
	}

	public void putTower(int x, int y) {
		map.checkTower(x, y);
		Tower tower = new Tower();
		ticker.addUnit(tower);
		map.putTower(x, y, tower);
	}

	public void putRune(int x, int y, RuneType runeType) {
		map.checkRune(x, y);
		Rune rune;
		switch (runeType) {
		case Dwarf:
			rune = new DwarfRune();
			break;
		case Elf:
			rune = new ElfRune();
			break;
		case Hobbit:
			rune = new HobbitRune();
			break;
		case Man:
			rune = new ManRune();
			break;
		case Range:
			rune = new RangeRune();
			break;
		case Reload:
			rune = new ReloadRune();
			break;
		}
		rune = new Rune();
		map.putRune(x, y, rune);
	}

	public void putSwamp(int x, int y) {
		map.checkSwamp(x, y);
		Swamp swamp = new Swamp();
		ticker.addUnit(swamp);
		map.putSwamp(x, y, swamp);
	}

	public void putFog(int x, int y) {
		Fog fog = new Fog(this, Common.fog_timetoleave);
		ticker.addUnit(fog);
	}
	
	public void removeFog(Fog fog) {
		ticker.remove(fog);
	}


	public void tick() {
		ticker.tick();

		ticker.remove(map.getFinishedUnits());
		map.deleteFinishedUnits();
	}

	public void notifyIfDead(EnemyUnit e) {
		ticker.remove(e);
		magitzka += Common.kill_mTz;
	}


	public void loadMap(String filename) {
		map = new Map (filename);
	}

	public void addUnit(EnemyUnit enemyUnit) {
		ticker.addUnit(enemyUnit);
		enemyUnit.setGame(this);
	}
}
