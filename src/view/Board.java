package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.Game;

import common.Strategy;

import control.Control;

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
		setSize(1000, 540);
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
		Strategy strategy = new Strategy(game);
		Control control = new Control(game);
		GameView gameView = new GameView(control, game);
		game.setView(gameView);
		Board board = new Board();
		SidePanel side = new SidePanel(gameView.getStatusPanel(), control);

		game.loadMap("map1.txt");
		board.add(game.getView(), BorderLayout.CENTER);
		board.add(side, BorderLayout.EAST);

		board.setVisible(true);

		Timer t = new Timer(20, strategy);
		t.start();

	}
}
