package model.runes;

import common.Common;

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
