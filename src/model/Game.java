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
import control.EnemyType;
import control.ProtoManager;
import control.RuneType;

public class Game {

	private Map map;
	private Ticker ticker;
	private GameView gameView;
	private int life = Common.life;
	private int magitzka = Common.start_mTz;

	public Game() {
		ticker = new Ticker();
		gameView = new GameView();
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
			tower.setView(ViewFactory.createView(tower));
			Rune rune = new Rune();
			rune.setView(ViewFactory.createView(rune));
			tower.putFirstRune(rune);
			ticker.addUnit(tower);
			map.putTower(x, y, tower);
			return true;
		} else {
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
		enemyUnit.ProtoType_setName(ProtoManager.getUnitName());
	}

	public void addUnit(EnemyType type, String name) {
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
		newEnemy.ProtoType_setName(name);

		map.getFirstRoad().addUnit(newEnemy);
		ticker.addUnit(newEnemy);
	}

	public GameView getView() {
		return gameView;
	}

}
