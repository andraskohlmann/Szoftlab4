package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image bottomLayer;

	private List<ViewBase> views;

	public GameView() {
		views = new ArrayList<ViewBase>();
	}

	public void addView(ViewBase view) {
		views.add(view);
	}

	@Override
	public void paintComponent(Graphics graphics) {
		if (bottomLayer == null) {
			initBottomLayer();
		}

		Graphics g = bottomLayer.getGraphics();

		for (ViewBase view : views) {
			view.draw(g);
		}

		graphics.drawImage(bottomLayer, 0, 0, null);

	}

	private void initBottomLayer() {
		bottomLayer = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		Graphics g = bottomLayer.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
