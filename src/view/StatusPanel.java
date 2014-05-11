package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Common;

public class StatusPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel magitzkaLevel;
	private JLabel magitzkaLevelDisplay;
	private JLabel lifeLevel;
	private JLabel lifeLevelDisplay;

	public StatusPanel() {
		
		setBackground(Color.BLACK);
		
		lifeLevel = new JLabel("Life:");
		lifeLevel.setForeground(Color.WHITE);
		add(lifeLevel);
		
		lifeLevelDisplay = new JLabel(Integer.toString(Common.life));
		lifeLevelDisplay.setForeground(Color.WHITE);
		add(lifeLevelDisplay);
		
		magitzkaLevel = new JLabel("Magitzka:");
		magitzkaLevel.setForeground(Color.WHITE);
		add(magitzkaLevel);

		magitzkaLevelDisplay = new JLabel(Integer.toString(Common.start_mTz));
		magitzkaLevelDisplay.setForeground(Color.WHITE);
		add(magitzkaLevelDisplay);
	}

	public void setMagitzka(int magitzka) {
		magitzkaLevelDisplay.setText(Integer.toString(magitzka));
		this.repaint();
	}
	public void setLife(int life) {
		lifeLevelDisplay.setText(Integer.toString(life));
		this.repaint();
	}

}
