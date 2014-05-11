package view;

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
		lifeLevel = new JLabel("Life:");
		add(lifeLevel);
		
		lifeLevelDisplay = new JLabel(Integer.toString(Common.life));
		add(lifeLevelDisplay);
		
		magitzkaLevel = new JLabel("Magitzka:");
		add(magitzkaLevel);

		magitzkaLevelDisplay = new JLabel(Integer.toString(Common.start_mTz));
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
