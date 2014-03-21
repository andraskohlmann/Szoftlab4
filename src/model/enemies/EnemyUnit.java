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

	public abstract void gotHit(Projectile p);

	public abstract void gotSlowed(Slime s);

	public void setRoad(Road r) {
		SkeletonUI.enterFunction(this, "setRoad");

		roadToNotice = r;

		SkeletonUI.leaveFunction();
	}

	public void tick() {
		SkeletonUI.enterFunction(this, "tick");

		// Itt meg lehetne kérdezni, hogy akar e lépni az enemyunit,
		// és attól függõvé tenni ezt a stepme-t - Kohlmann
		roadToNotice.stepMe(this);

		SkeletonUI.leaveFunction();
	}
}
