package model.mapitem;

import control.SkeletonUI;
import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Road.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Road extends Tile {

	private EnemyUnit enemyList;

	private Swamp swamp;

	private Tower towersToNotify;

	private Road nextRoad;

	public boolean checkSwamp() {
		SkeletonUI.enterFunction(this, "checkSwamp");
		
		SkeletonUI.leaveFunction(true);
		return true;
	}

	public void addTower(int distance, Tower t) {

	}

	public void putRune(Rune r) {
		SkeletonUI.enterFunction(this, "putRune", r);

		SkeletonUI.leaveFunction(false);
	}

	public void deadNotice(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "deadNotice");

		SkeletonUI.leaveFunction();
	}

	public boolean checkRune() {
		SkeletonUI.enterFunction(this, "checkRune");

		boolean available = swamp.checkRune();

		SkeletonUI.leaveFunction(available);
		return available;
	}

	public void putSwamp(Swamp s) {
		SkeletonUI.enterFunction(this, "putSwamp", s);
           
		SkeletonUI.leaveFunction();
	}

	public boolean addUnit(EnemyUnit e) {
		return false;
	}

	public void stepMe(EnemyUnit enemyUnit) {

	}
}
