package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.EnemyType;
import model.Game;

public class Strategy implements ActionListener {

	private Game game;
	private int ticks = 0;

	private static final int second = 50;
	private static final int firstDelay = 5;
	private static final int firstWave = firstDelay + 20;
	private static final int secondDelay = firstWave + 10;
	private static final int secondWave = secondDelay + 40;
	private static final int thirdDelay = secondWave + 15;
	private static final int thirdWave = thirdDelay + 60;

	private static final int firstRep = 100;
	private static final int secondrep = 50;
	private static final int thirdrep = 20;

	public Strategy(Game g) {
		game = g;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ticks++;

		game.tick();

		if (ticks > firstDelay * second && ticks < firstWave * second) {
			firstVawe(ticks);
		} else if (ticks > secondDelay * second && ticks < secondWave * second) {
			secondVawe(ticks);
		} else if (ticks > thirdDelay * second && ticks < thirdWave * second) {
			thirdVawe(ticks);
		}
	}

	private void thirdVawe(int ticks2) {
		if (ticks % thirdrep == 0) {
			addRandomunit();
		}
	}

	private void secondVawe(int ticks2) {
		if (ticks % secondrep == 0) {
			addRandomunit();
		}
	}

	private void firstVawe(int ticks2) {
		if (ticks % firstRep == 0) {
			addRandomunit();
		}
	}

	private void addRandomunit() {
		switch (Randomizer.randomInt(4)) {
		case 0:
			game.addUnit(EnemyType.dwarf);
			break;
		case 1:
			game.addUnit(EnemyType.elf);
			break;
		case 2:
			game.addUnit(EnemyType.hobbit);
			break;
		case 3:
			game.addUnit(EnemyType.man);
			break;
		default:
			break;
		}
	}
}
