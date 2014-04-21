package model.enemies;

import control.SkeletonUI;
import model.ActiveUnit;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public abstract class EnemyUnit implements ActiveUnit {
	protected Road roadToNotice;
	protected Game gameToNotice;
	
	protected int health;
	
	protected int tickDivider;
	protected int counter;

	public abstract void gotHit(Projectile p);

	public abstract void gotSlowed(Slime s);

	public void setRoad(Road r) {
		SkeletonUI.enterFunction(this, "setRoad");

		roadToNotice = r;

		SkeletonUI.leaveFunction();
	}

	public void tick() {
		SkeletonUI.enterFunction(this, "tick");

		if (SkeletonUI.booleanQuestion("Is the enemy ready to step?")) {
			roadToNotice.stepMe(this);
		}

		SkeletonUI.leaveFunction();
	}
}
