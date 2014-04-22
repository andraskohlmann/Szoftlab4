package model;

import model.enemies.EnemyUnit;
import model.mapitem.Fog;
import model.mapitem.Map;

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

	}

	public void putRune(int x, int y, String runeType) {

	}

	public void putSwamp(int x, int y) {

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
		// TODO Auto-generated method stub

	}

	public void addUnit(EnemyUnit enemyUnit) {
		ticker.addUnit(enemyUnit);
		enemyUnit.setGame(this);
	}
}
