package model;

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
		return false;
	}

	public void addTower(int distance, Tower t) {

	}

	public void putRune(Rune r) {

	}

	public void deadNotice() {

	}

	public boolean checkRune() {
		return false;
	}

	public void putSwamp(Swamp s) {

	}

	public boolean addUnit(EnemyUnit e) {
		return false;
	}

	public void stepMe(EnemyUnit enemyUnit) {

	}
}
