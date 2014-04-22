package model;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.EnemyUnit;
import model.enemies.Hobbit;
import model.enemies.Man;
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
import control.EnemyType;
import control.RuneType;

public class Game {

	private Map map;
	private Ticker ticker;

	private int life = Common.life;
	private int magitzka = Common.start_mTz;
	
	public Game() {
		ticker = new Ticker();
	}

	public int getLife() {
		return life;
	}

	public int getMagitzka() {
		return magitzka;
	}

	public Map getMap() {
		return map;
	}

	public boolean putTower(int x, int y, String name) {
		if (map.checkTower(x, y)) {
			Tower tower = new Tower();
			tower.ProtoType_setName(name);
			ticker.addUnit(tower);
			map.putTower(x, y, tower);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean putRune(int x, int y, RuneType runeType) {
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
		default:
			rune = new ReloadRune();
			break;
		}
		
		if (map.checkRune(x, y, rune)) {
			map.putRune(x, y, rune);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean putSwamp(int x, int y,String name) {
		if (map.checkSwamp(x, y)) {
			Swamp swamp = new Swamp();
			swamp.ProtoType_setName(name);
			ticker.addUnit(swamp);
			map.putSwamp(x, y, swamp);
			return true;
		}
		else {
			return false;
		}
	}

	public void putFog(int x, int y) {
		Fog fog = new Fog(this, Common.fog_timetoleave);
		ticker.addUnit(fog);
		map.putFog(x, y, fog);
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
		map = new Map(filename);
	}

	public void addUnit(EnemyUnit enemyUnit) {
		ticker.addUnit(enemyUnit);
		enemyUnit.setGame(this);
	}

	public void addUnit(EnemyType type,String name) {
		EnemyUnit newEnemy;
		switch (type) {
		case dwarf:
			newEnemy = new Dwarf(this);
			break;
		case elf:
			newEnemy = new Elf(this);
			break;
		case hobbit:
			newEnemy = new Hobbit(this);
			break;
		default:
			newEnemy = new Man(this);
			break;
		}
		newEnemy.ProtoType_setName(name);
		
		map.getFirstRoad().addUnit(newEnemy);
		ticker.addUnit(newEnemy);
	}
	
}
