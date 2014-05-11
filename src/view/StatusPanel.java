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

	public StatusPanel() {
		magitzkaLevel = new JLabel("Magitzka:");
		add(magitzkaLevel);

		magitzkaLevelDisplay = new JLabel(Integer.toString(Common.start_mTz));
		add(magitzkaLevelDisplay);
	}

	public void setMagitzka(int magitzka) {
		magitzkaLevelDisplay.setText(Integer.toString(magitzka));
		this.repaint();
	}

}
