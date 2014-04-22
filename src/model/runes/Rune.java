package model.runes;

import model.Common;

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
		s.setNumbers(this);
	}

	public int getDistance() {
		return distance;
	}
}
