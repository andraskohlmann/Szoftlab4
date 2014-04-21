package model.runes;

import control.SkeletonUI;

public class Rune {

	protected int distance;
	
	protected int reloadTime;
	
	public int dmgDwarf;
	public int dmgHobbit;
	public int dmgElf;
	public int dmgMan;

	public Rune() {
		distance = 4;
		
		reloadTime = 10;
		
		dmgDwarf = 10;
		dmgHobbit = 10;
		dmgElf = 10;
		dmgMan = 10;
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
