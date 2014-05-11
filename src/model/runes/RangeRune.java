package model.runes;

import common.Common;

public class RangeRune extends Rune {

	public RangeRune() {
		super();
		distance = Common.rangedistance;
	}

	@Override
	public boolean availableForSwamp() {
		return false;
	}

}
