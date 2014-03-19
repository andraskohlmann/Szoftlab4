package control;

import model.Game;
import model.Ticker;
import model.enemies.EnemyUnit;
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
		// TODO Auto-generated method stub
//		Game game = new Game();
//		SkeletonUI.addObject(game, "game", true);
//		game.tick();

	}
	
	public static void TowerTick(Ticker ticker, Tower t, Game g) {
		
		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		
		Road rd = new Road();
		SkeletonUI.addObject(rd, "rd", true);
		
		EnemyUnit e = new EnemyUnit();
		SkeletonUI.addObject(e, "e", true);
		t.Skeleton_AddUnit(e);
		
		Swamp s = new Swamp();
		SkeletonUI.addObject(s,  "s",  true);
		
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
		
		g.Skeleton_MouseOnTile();
	}

}
