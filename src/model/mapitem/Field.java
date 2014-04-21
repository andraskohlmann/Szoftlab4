package model.mapitem;

import model.friendly.Tower;
import model.runes.Rune;
import control.SkeletonUI;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Field.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Field extends Tile {
	private Tower tower;

	public void Skeleton_TowerSetter(Tower t) {
		tower = t;
	}

	public boolean checkTower() {
		if (tower == null)
			return true;
		return false;
	}

	public void putRune(Rune r) {
		tower.putRune(r);
		addTower(r.getDistance(), tower);
	}

	public void putTower(Tower t) {
		tower = t;
	}

	public boolean checkRune() {
		return tower.checkRune();
	}
	
	public void addFog(Fog f) {
		
	}
}
