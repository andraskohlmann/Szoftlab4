package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.Game;
import control.Control;
import control.EnemyType;

/**
 * 
 * A játék alapértelmezetten megjelenõ ablaka, ezen történik minden esemény.
 * 
 */
public class Board extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor, az ablak méretének, tulajdonságainak inicializálása.
	 */
	public Board() {
		setSize(600, 600);
		setResizable(false);
		setTitle("Tower Defense");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 50);
	}

	/**
	 * Main függvény
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Control control = new Control(game);
		GameView gameView = new GameView(control, game);
		game.setView(gameView);
		Board board = new Board();
		MenuPanel menu = new MenuPanel(control);

		game.loadMap("3a.map");
		board.add(game.getView(), BorderLayout.CENTER);
		board.add(menu, BorderLayout.EAST);

		// game.putTower(6, 3, "Segglyuk");
		// game.putSwamp(1, 2, "PICSA");

		game.addUnit(EnemyType.elf, "Buzikám");

		// game.putRune(6, 3, RuneType.Range);
		// game.putRune(1, 2, RuneType.Dwarf);

		board.setVisible(true);

		for (int i = 0; i < 100000; i++) {
			// if (i % Common.tickElf == 0) game.addUnit(EnemyType.elf,
			// "Buzikám");
			game.tick();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
