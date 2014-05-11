package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import control.Control;

public class SidePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SidePanel(StatusPanel status, Control control) {
		setLayout(new BorderLayout());

		add(new MenuPanel(control), BorderLayout.CENTER);
		add(status, BorderLayout.NORTH);
	}

}
