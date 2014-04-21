package model.runes;

import model.Common;
import control.SkeletonUI;

public class Rune {

	protected int distance;
	
	protected int reloadTime;
	
	public int dmgDwarf;
	public int dmgHobbit;
	public int dmgElf;
	public int dmgMan;

	public Rune() {
		distance = Common.distance;
		
		reloadTime = Common.reloadTime;
		
		dmgDwarf = Common.dmgDwarf;
		dmgHobbit = Common.dmgHobbit;
		dmgElf = Common.dmgElf;
		dmgMan = Common.dmgMan;
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
