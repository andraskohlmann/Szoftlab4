package control;

import model.Game;
import model.Ticker;
import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
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
		
		Swamp s = new Swamp();
		SkeletonUI.addObject(s,  "s",  true);
		
		ticker.tick();	
		
	}

}
