package view;

import javax.swing.JFrame;

import model.Game;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Board() {
		this.setSize(600, 600);
		this.setResizable(false);
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game();
		game.loadMap("3a.map");
		board.add(game.getView());
		
		board.setVisible(true);
	}
}
