package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;

	private List<ViewBase> views;
	
	public GameView() {
		views = new ArrayList<ViewBase>();
	}
	
	public void addView(ViewBase view) {
		views.add(view);
	}

	@Override
	public void paint(Graphics g) {
		
		for (ViewBase view : views) {
			view.draw(g);
		}
		
	}

}