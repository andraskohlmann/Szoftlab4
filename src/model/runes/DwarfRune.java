package model.runes;

import model.Common;

public class DwarfRune extends Rune {

	public DwarfRune() {
		super();
		dmgDwarf = Common.specialdmgDwarf;
	}
	
	public void modifySlime(Slime s) {
		s.setNumbers(Common.swamp_specialslow, Common.swamp_slowvalue,
				Common.swamp_slowvalue, Common.swamp_slowvalue);
	}
}
