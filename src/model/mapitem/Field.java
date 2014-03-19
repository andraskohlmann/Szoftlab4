package model.mapitem;

import control.SkeletonUI;
import model.friendly.Tower;
import model.runes.Rune;

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

	public boolean checkTower() {
		return false;

	}

	public void putRune(Rune r) {
		SkeletonUI.enterFunction(this, "putRune", r);
		
			int distance = r.getDistance();
			
		
		SkeletonUI.leaveFunction();
	}

	public void putTower(Tower t) {

	}

	public boolean checkRune() {
		SkeletonUI.enterFunction(this, "checkRune");

		boolean available = tower.checkRune();
		
		SkeletonUI.leaveFunction(available);
		return available;

	}

}
