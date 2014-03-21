package model.runes;

import control.SkeletonUI;

public class Rune {

	private int distance;

	// Csak default konstruktor! Tov�bbi m�dos�t�s sz�ks�ges!!!
	public Rune() {
		distance = 4;
	}

	public void modifyProjectile(Projectile p) {
		SkeletonUI.enterFunction(this, "modifyProjectile", p);

		p.setDamage(this);

		SkeletonUI.leaveFunction();
	}

	public void modifySlime(Slime s) {
		SkeletonUI.enterFunction(this, "modifySlime", s);

		s.setNumbers(this);

		SkeletonUI.leaveFunction();
	}

	public int getDistance() {
		SkeletonUI.enterFunction(this, "getDistance");

		SkeletonUI.leaveFunction(distance);
		return distance;
	}
}
