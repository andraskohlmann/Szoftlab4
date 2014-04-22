package model.runes;

import model.Common;

public class HobbitRune extends Rune {

	public HobbitRune() {
		super();
		dmgHobbit = Common.specialdmgHobbit;
	}
	
	public void modifySlime(Slime s) {
		s.setNumbers(Common.swamp_slowvalue, Common.swamp_specialslow,
				Common.swamp_slowvalue, Common.swamp_slowvalue);
	}
}
