package model;

import java.util.List;

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
import view.GameView;
import view.ViewFactory;

import common.Common;

import control.EnemyType;
import control.RuneType;

public class Game {

	private Map map;
	private Ticker ticker;
	private GameView gameView;
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

	public boolean putTower(int x, int y) {
		if (map.checkTower(x, y) && magitzka > Common.tower_mTz) {
			Tower tower = new Tower();
			tower.setView(ViewFactory.createView(tower));
			Rune rune = new Rune();
			rune.setView(ViewFactory.createView(rune));
			tower.putFirstRune(rune);
			ticker.addUnit(tower);
			map.putTower(x, y, tower);
			System.out.println(magitzka);
			magitzka -= Common.tower_mTz;
			return true;
		} else {
			return false;
		}
	}

	public boolean checkTower(int x, int y) {
		return map.checkTower(x, y);
	}

	public boolean putRune(int x, int y, RuneType runeType) {
		Rune rune;

		switch (runeType) {
		case Dwarf:
			DwarfRune dwarfRune = new DwarfRune();
			dwarfRune.setView(ViewFactory.createView(dwarfRune));
			rune = dwarfRune;
			break;
		case Elf:
			ElfRune elfRune = new ElfRune();
			elfRune.setView(ViewFactory.createView(elfRune));
			rune = elfRune;
			break;
		case Hobbit:
			HobbitRune hobbitRune = new HobbitRune();
			hobbitRune.setView(ViewFactory.createView(hobbitRune));
			rune = hobbitRune;
			break;
		case Man:
			ManRune manRune = new ManRune();
			manRune.setView(ViewFactory.createView(manRune));
			rune = manRune;
			break;
		case Range:
			RangeRune rangeRune = new RangeRune();
			rangeRune.setView(ViewFactory.createView(rangeRune));
			rune = rangeRune;
			break;
		default:
			ReloadRune reloadRune = new ReloadRune();
			reloadRune.setView(ViewFactory.createView(reloadRune));
			rune = reloadRune;
			break;
		}

		if (map.checkRune(x, y, rune)) {
			map.putRune(x, y, rune);
			return true;
		} else {
			return false;
		}
	}

	public boolean putSwamp(int x, int y, String name) {
		if (map.checkSwamp(x, y)) {
			Swamp swamp = new Swamp();
			swamp.setView(ViewFactory.createView(swamp));
			swamp.ProtoType_setName(name);
			Rune rune = new Rune();
			rune.setView(ViewFactory.createView(rune));
			swamp.putFirstRune(rune);
			ticker.addUnit(swamp);
			map.putSwamp(x, y, swamp);
			return true;
		} else {
			return false;
		}
	}

	public boolean checkSwamp(int x, int y) {
		return map.checkSwamp(x, y);
	}

	public void putFog(int x, int y) {
		Fog fog = new Fog(this, Common.fog_timetoleave);
		fog.setView(ViewFactory.createView(fog));
		ticker.addUnit(fog);
		map.putFog(x, y, fog);
	}

	public void removeFog(Fog fog) {
		ticker.remove(fog);
	}

	public void tick() {
		ticker.tick();

		List<EnemyUnit> finished = map.getFinishedUnits();

		life -= Common.damagePerUnit * finished.size();

		ticker.remove(finished);
		map.deleteFinishedUnits();

		gameView.repaint();
	}

	public void notifyIfDead(EnemyUnit e) {
		ticker.remove(e);
		magitzka += Common.kill_mTz;
	}

	public void loadMap(String filename) {
		map = new Map(filename, gameView);
	}

	public void addUnit(EnemyUnit enemyUnit) {
		ticker.concurrentAddUnit(enemyUnit);
		enemyUnit.setGame(this);
	}

	public void addUnit(EnemyType type) {
		EnemyUnit newEnemy;

		switch (type) {
		case dwarf:
			Dwarf dwarf = new Dwarf(this);
			dwarf.setView(ViewFactory.createView(dwarf));
			newEnemy = dwarf;
			break;
		case elf:
			Elf elf = new Elf(this);
			elf.setView(ViewFactory.createView(elf));
			newEnemy = elf;
			break;
		case hobbit:
			Hobbit hobbit = new Hobbit(this);
			hobbit.setView(ViewFactory.createView(hobbit));
			newEnemy = hobbit;
			break;
		default:
			Man man = new Man(this);
			man.setView(ViewFactory.createView(man));
			newEnemy = man;
			break;
		}

		map.getFirstRoad().addUnit(newEnemy);
		ticker.addUnit(newEnemy);
	}

	public GameView getView() {
		return gameView;
	}

	public void setView(GameView gameView2) {
		gameView = gameView2;
	}

}
