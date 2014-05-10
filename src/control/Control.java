package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Common;
import model.Game;

public class Control implements ActionListener, MouseListener, MouseMotionListener {

	private Game game;
	
	private enum ClickState {tower, swamp, elf, dwarf, hobbit, man, range, reload, none};
	private ClickState clickState = ClickState.none;
	
	private int mouseX;
	private int mouseY;
	
	public Control(Game g) {
		game = g;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		if (arg0.getActionCommand().equals("tower"))
			clickState = ClickState.tower;
		else if (arg0.getActionCommand().equals("swamp"))
			clickState = ClickState.swamp;
		else if (arg0.getActionCommand().equals("elfrune"))
			clickState = ClickState.elf;
		else if (arg0.getActionCommand().equals("manrune"))
			clickState = ClickState.man;
		else if (arg0.getActionCommand().equals("dwarfrune"))
			clickState = ClickState.dwarf;
		else if (arg0.getActionCommand().equals("hobbitrune"))
			clickState = ClickState.hobbit;
		else if (arg0.getActionCommand().equals("reloadrune"))
			clickState = ClickState.reload;
		else if (arg0.getActionCommand().equals("rangerune"))
			clickState = ClickState.range;
	}

	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX() / Common.tileWidth;
		int y = arg0.getY() / Common.tileWidth;
		System.out.println("X: " + arg0.getX() + " Y: " + arg0.getY());
		System.out.println("X: " + x +  " Y: " + y);
		if (clickState == clickState.tower) {
			System.out.println("click Tower");
			if (game.putTower(y, x, "t0000"))
				clickState = clickState.none;
		}
		else if (clickState == clickState.swamp)
			if (game.putSwamp(x, y, "s0000"))
				clickState = clickState.none;
		
		else if (clickState == clickState.elf)
			if (game.putRune(x, y, RuneType.Elf))
				clickState = clickState.none;
		
		else if (clickState == clickState.dwarf)
			if (game.putRune(x, y, RuneType.Dwarf))
				clickState = clickState.none;
		
		else if (clickState == clickState.hobbit)
			if (game.putRune(x, y, RuneType.Hobbit))
				clickState = clickState.none;
		
		else if (clickState == clickState.man)
			if (game.putRune(x, y, RuneType.Man))
				clickState = clickState.none;
		
		else if (clickState == clickState.range)
			if (game.putRune(x, y, RuneType.Range))
				clickState = clickState.none;
		
		else if (clickState == clickState.reload)
			if (game.putRune(x, y, RuneType.Reload))
				clickState = clickState.none;
	}
	
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		
		System.out.println("mX: " + mouseX + " mY: " + mouseY);	
	}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	public void mouseDragged(MouseEvent arg0) {}
}
