package model.runes;

import model.Common;

public class ReloadRune extends Rune {

	public ReloadRune() {
		super();
		reloadTime = Common.reloadrunereloadtime;
	}
	
	@Override
	public boolean availableForSwamp() {
		return false;
	}

}
