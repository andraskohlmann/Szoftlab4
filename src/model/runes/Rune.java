package model.runes;

import control.SkeletonUI;

public class Rune {

	private int distance;
	
	public int dmgDwarf;
	public int dmgHobbit;
	public int dmgElf;
	public int dmgMan;

	// Csak default konstruktor! További módosítás szükséges!!!
	public Rune() {
		distance = 4;
		
		dmgDwarf = 30;
		dmgHobbit = 40;
		dmgElf = 50;
		dmgMan = 50;
	}

	public void modifyProjectile(Projectile p) {
		p.setDamage(this);
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
