package view;

import javax.swing.JFrame;

import model.Game;

public class Board extends JFrame{
	
	public Board() {
		this.setSize(600, 600);
		this.setResizable(false);
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game();
		game.loadMap("3a.map");
		board.add(game.getView());
	}
}
