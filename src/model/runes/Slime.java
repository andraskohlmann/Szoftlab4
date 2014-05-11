package model.runes;

import common.Common;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;

public class Slime {

	private int slowDwarf = Common.swamp_slowvalue;
	private int slowHobbit = Common.swamp_slowvalue;
	private int slowElf = Common.swamp_slowvalue;
	private int slowMan = Common.swamp_slowvalue;

	public int slowMe(Dwarf d) {
		return slowDwarf;
	}

	public int slowMe(Hobbit h) {
		return slowHobbit;
	}

	public int slowMe(Elf e) {
		return slowElf;
	}

	public void setNumbers(int d, int h, int e, int m) {
		slowDwarf = d;
		slowHobbit = h;
		slowElf = e;
		slowMan = m;
	}

	public int slowMe(Man m) {
		return slowMan;
	}

}
