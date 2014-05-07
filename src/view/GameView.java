package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
	public void paintComponent(Graphics graphics) {
		//Image img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		
		//Graphics g = img.getGraphics();
		
		for (ViewBase view : views) {
			view.draw(graphics);
		}
		
		//graphics.drawImage(img, 0, 0, null);
		
	}

}
