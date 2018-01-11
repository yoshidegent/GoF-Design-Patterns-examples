package com.realdolmen.ood020.factorymethod;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FerryFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected JButton newVehicle, costButton;
	protected JTextField regNo;
	protected JPanel panel1, panel2, panel3, panel4, panel5, panel6;
	protected JLabel spacesLabel, typeLabel, costLabel;
	protected JLabel regLabel, passLabel, berthsLabel, warning;

	Choice passChoice, berthsChoice;

	ButtonGroup cbg;
	JCheckBox[] checkboxes;

	protected JMenuBar menubar1;
	protected JMenu menu1;
	protected JMenuItem quit;
	protected JMenuItem empty;
	protected JMenuItem save;

	private Ferry theFerry;

	public FerryFrame(String title, Ferry f) {
		super(title);

		theFerry = f;

		menubar1 = new JMenuBar();

		setJMenuBar(menubar1);

		menu1 = new JMenu("Control");

		quit = new JMenuItem("Quit");
		quit.addActionListener(this);
		menu1.add(quit);

		empty = new JMenuItem("Empty");
		empty.addActionListener(this);
		menu1.add(empty);

		save = new JMenuItem("Save");
		save.addActionListener(this);
		menu1.add(save);

		menubar1.add(menu1);

		newVehicle = new JButton("Add Vehicle");
		newVehicle.addActionListener(this);

		costButton = new JButton("Calculate Cost");
		costButton.addActionListener(this);

		spacesLabel = new JLabel("Spaces left: " + theFerry.spaceLeft());
		typeLabel = new JLabel("Type of Vehicle: ");
		costLabel = new JLabel("Cost is: ");
		regLabel = new JLabel("Vehicle Registration: ");
		passLabel = new JLabel("Number of Passengers: ");
		warning = new JLabel("                 ");
		berthsLabel = new JLabel("Number of Spaces: ");
		regNo = new JTextField(10);
		regNo.addActionListener(this);

		cbg = new ButtonGroup(); // to make them mutually exclusive
		checkboxes = new JCheckBox[2];
		checkboxes[0] = new JCheckBox("Car", true);
		checkboxes[1] = new JCheckBox("Truck", false);
		cbg.add(checkboxes[0]);
		cbg.add(checkboxes[1]);

		passChoice = new Choice();
		passChoice.addItem("1");
		passChoice.addItem("2");
		passChoice.addItem("3");
		passChoice.addItem("4");

		berthsChoice = new Choice();
		berthsChoice.addItem("2");
		berthsChoice.addItem("3");

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(9, 1));

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2));
		panel2.add(passLabel);
		panel2.add(passChoice);

		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2));
		panel3.add(berthsLabel);
		panel3.add(berthsChoice);

		panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1, 2));
		panel5.add(costLabel);
		panel5.add(costButton);

		panel6 = new JPanel();
		panel6.setLayout(new GridLayout(1, 2));
		panel6.add(regLabel);
		panel6.add(regNo);

		panel1.add(spacesLabel);
		panel1.add(typeLabel);
		panel1.add(checkboxes[0]);
		panel1.add(checkboxes[1]);
		panel1.add(panel6);
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.add(warning);
		panel1.add(panel5);

		panel4 = new JPanel();
		panel4.add(newVehicle);

		this.add("West", panel1);
		this.add("South", panel4);
		this.pack();

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == newVehicle) {
			Vehicle v = null;
			boolean added = false;
			int berths = 0;
			// get details and add a vehicle
			String reg = regNo.getText();
			int noPass = Integer.parseInt(passChoice.getSelectedItem());

			if (checkboxes[0].isSelected()) {
				v = new Vehicle(noPass, reg);
				added = theFerry.addVehicle(v);
			} else {
				berths = Integer.parseInt(berthsChoice.getSelectedItem());
				v = new Truck(noPass, reg, berths);
				added = theFerry.addVehicle(v);
			}
			if (added)
				warning.setText("Vehicle added successfully");
			else
				warning.setText("Not added - not enough room");

			spacesLabel.setText("Spaces left: " + theFerry.spaceLeft());
			cbg.setSelected(checkboxes[0].getModel(), true);
			passChoice.select(0);
			berthsChoice.select(0);
			costLabel.setText("Cost is: ");
		} else if (event.getSource() == costButton) {
			Vehicle v = null;
			int berths = 0;
			// get details to cost vehicle
			String reg = regNo.getText();
			int noPass = Integer.parseInt(passChoice.getSelectedItem());

			if (checkboxes[0].isSelected()) {
				v = new Vehicle(noPass, reg);
				costLabel.setText("Cost is: €" + v.getCost());
			} else {
				berths = Integer.parseInt(berthsChoice.getSelectedItem());
				v = new Truck(noPass, reg, berths);
				costLabel.setText("Cost is: €" + v.getCost());
			}
		} else if (event.getSource() == empty) {
			theFerry.emptyFerry();
			spacesLabel.setText("Spaces left: " + theFerry.spaceLeft());
			cbg.setSelected(checkboxes[0].getModel(), true);
			passChoice.select(0);
			berthsChoice.select(0);
		} else if (event.getSource() == quit) {
			this.dispose();
			System.exit(0);
		} else if (event.getSource() == save) {
			warning.setText("Saving ... ");
			try {
				theFerry.save();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
