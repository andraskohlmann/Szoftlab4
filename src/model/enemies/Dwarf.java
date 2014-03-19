//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Dwarf.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//
package model.enemies;

import control.SkeletonUI;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public class Dwarf extends EnemyUnit {
	
	public Dwarf(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}
	
	public Dwarf() {
		
	}
	
	public void gotHit(Projectile p) {
		SkeletonUI.enterFunction(this, "gotHit", p);
		
		p.damageMe(this);
		
		if (SkeletonUI.booleanQuestion("Is the enemy unit dead?")) {
			roadToNotice.deadNotice(this);
			gameToNotice.notifyIfDead(this);
		}
		
		SkeletonUI.leaveFunction();
	}

	public void gotSlowed(Slime s) {
		SkeletonUI.enterFunction(this, "gotSlowed", s);
		
		SkeletonUI.leaveFunction();
	}
}