package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Control;

public class MenuPanel extends JPanel {

	private JButton towerButton;
	private JButton swampButton;
	private JButton elfRuneButton;
	private JButton manRuneButton;
	private JButton dwarfRuneButton;
	private JButton hobbitRuneButton;
	private JButton rangeRuneButton;
	private JButton reloadRuneButton;
	
	public MenuPanel(Control control) {
		towerButton = new JButton("Tower");
		towerButton.setActionCommand("tower");
		towerButton.addActionListener(control);
		
		swampButton = new JButton("Swamp");
		swampButton.setActionCommand("swamp");
		swampButton.addActionListener(control);
		
		elfRuneButton = new JButton("ElfRune");
		elfRuneButton.setActionCommand("elfrune");
		elfRuneButton.addActionListener(control);
		
		manRuneButton = new JButton("ManRune");
		manRuneButton.setActionCommand("manrune");
		manRuneButton.addActionListener(control);
		
		dwarfRuneButton = new JButton("DwarfRune");
		dwarfRuneButton.setActionCommand("dwarfrune");
		dwarfRuneButton.addActionListener(control);
		
		hobbitRuneButton = new JButton("HobbitRune");
		hobbitRuneButton.setActionCommand("hobbitrune");
		hobbitRuneButton.addActionListener(control);
		
		rangeRuneButton = new JButton("RangeRune");
		rangeRuneButton.setActionCommand("rangerune");
		rangeRuneButton.addActionListener(control);
		
		reloadRuneButton = new JButton("ReloadRune");
		reloadRuneButton.setActionCommand("reloadrune");
		reloadRuneButton.addActionListener(control);
	}
	
	
}
