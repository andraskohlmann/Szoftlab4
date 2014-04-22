package model.runes;

import model.Common;

public class ElfRune extends Rune {

	public ElfRune() {
		super();
		dmgElf = Common.specialdmgElf;
	}
	
	public void modifySlime(Slime s) {
		s.setNumbers(Common.swamp_slowvalue, Common.swamp_slowvalue,
				Common.swamp_specialslow, Common.swamp_slowvalue);
	}
}
