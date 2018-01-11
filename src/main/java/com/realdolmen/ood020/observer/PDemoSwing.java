package com.realdolmen.ood020.observer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PDemoSwing extends JFrame implements ActionListener, Observer
{

	private static final long serialVersionUID = 1L;
	protected JButton qbutton;
	protected JPanel panel1, panel2, panel3;
	protected JLabel lb, fnl, snl, al;
	protected JMenuBar menubar1;
	protected JMenu menu1;
	protected JMenuItem about;

	protected Person aperson;

	public PDemoSwing(String title, Person p) {
		super(title);

		aperson = p;
		aperson.addObserver(this);

		menubar1 = new JMenuBar();

		this.setJMenuBar(menubar1);

		menu1 = new JMenu("Info");

		about = new JMenuItem("About");
		about.addActionListener(this);
		menu1.add(about);

		menubar1.add(menu1);

		qbutton = new JButton("Quit");
		qbutton.addActionListener(this);

		lb = new JLabel("Person Details");
		fnl = new JLabel("Forename: " + aperson.getForename());
		snl = new JLabel("Surname: " + aperson.getSurname());
		al = new JLabel("Age: " + aperson.getAge());

		panel1 = new JPanel();

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 1));

		panel1.add(qbutton);

		panel2.add(fnl);
		panel2.add(snl);
		panel2.add(al);

		this.getContentPane().add("North", lb);
		this.getContentPane().add("South", panel1);
		this.getContentPane().add("Center", panel2);
		this.pack();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == qbutton) {
			this.dispose();
			System.exit(0);
		} else if (event.getSource() == about) {
			lb.setText("GUI for Person");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		al.setText("Age: " + aperson.getAge());
	}
}
