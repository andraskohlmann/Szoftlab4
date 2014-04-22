package model.runes;

import model.Common;

public class ManRune extends Rune {

	public ManRune() {
		super();
		dmgMan = Common.specialdmgMan;
	}
	
	public void modifySlime(Slime s) {
		s.setNumbers(Common.swamp_slowvalue, Common.swamp_slowvalue,
				Common.swamp_slowvalue, Common.swamp_specialslow);
	}
}
