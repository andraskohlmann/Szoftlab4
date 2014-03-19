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

	}
	
	public static void TowerTick(Ticker ticker, Tower t, Game g) {
		
		Rune r = new Rune();
		SkeletonUI.addObject(r, "r", true);
		
		Road rd = new Road();
		SkeletonUI.addObject(rd, "rd", true);
		
//		EnemyUnit e = new EnemyUnit();
//		SkeletonUI.addObject(e, "e", true);
//		t.Skeleton_AddUnit(e);
		
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
		
		m.Skeleton_FieldSetter(f);
		m.Skeleton_RoadSetter(r);
		
		f.Skeleton_TowerSetter(t);
		r.Skeleton_SwampSetter(s);
		
		
		g.Skeleton_MouseOnTile_Rune();
	}
	
	public static void PutSwamp(){
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
