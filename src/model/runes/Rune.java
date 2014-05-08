package model.runes;

import model.Common;

public class Rune {

	protected int distance;

	protected int reloadTime;

	protected int dmgDwarf;
	protected int dmgHobbit;
	protected int dmgElf;
	protected int dmgMan;

	protected int slowDwarf;
	protected int slowHobbit;
	protected int slowElf;
	protected int slowMan;
	
	private Object view;
	
	public void setView(Object v) {
		view = v;
	}
	
	public Object getView() {
		return view;
	}	

	public Rune() {
		distance = Common.distance;

		reloadTime = Common.reloadTime;

		dmgDwarf = Common.dmgDwarf;
		dmgHobbit = Common.dmgHobbit;
		dmgElf = Common.dmgElf;
		dmgMan = Common.dmgMan;

		slowDwarf = Common.swamp_slowvalue;
		slowHobbit = Common.swamp_slowvalue;
		slowElf = Common.swamp_slowvalue;
		slowMan = Common.swamp_slowvalue;
	}

	public void modifyProjectile(Projectile p) {
		p.setDamage(dmgDwarf, dmgHobbit, dmgElf, dmgMan);
	}

	public void modifySlime(Slime s) {
		s.setNumbers(slowDwarf, slowHobbit, slowElf, slowMan);
	}

	public int getDistance() {
		return distance;
	}

	public boolean availableForSwamp() {
		return true;
	}
}
