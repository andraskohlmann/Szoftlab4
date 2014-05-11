package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import control.Control;

public class SidePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuPanel menu;
	StatusPanel status;
	
	
	public SidePanel(StatusPanel status,Control control)
	{
		menu = new MenuPanel(control);
		this.status = status;

		setLayout(new BorderLayout());
		
		add(menu,BorderLayout.CENTER);
		add(status,BorderLayout.NORTH);
	}

}
