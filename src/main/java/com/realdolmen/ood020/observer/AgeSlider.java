package com.realdolmen.ood020.observer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AgeSlider extends JFrame implements ActionListener, Observer
{
	private static final long serialVersionUID = 1L;
	protected JButton qbutton;
	protected JPanel panel1;
	protected JLabel al;
	protected JSlider js;

	protected Person aperson;

	public AgeSlider(String title, Person p) {
		super(title);

		aperson = p;
		aperson.addObserver(this);

		// register as an observer of person
		// p.attach(this);

		qbutton = new JButton("Quit");
		qbutton.addActionListener(this);

		al = new JLabel("Age: " + aperson.getAge());

		js = new JSlider(0, 100, aperson.getAge());
		js.addChangeListener(new SliderListener());
		panel1 = new JPanel();

		panel1.setLayout(new GridLayout(3, 1));

		panel1.add(qbutton);
		panel1.add(js);
		panel1.add(al);

		this.getContentPane().add("Center", panel1);
		this.pack();
	}

	// inner class to listen to slider
	class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			// only one component could have done this
			// so get value from slider
			aperson.setAge(js.getValue());
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == qbutton) {
			this.dispose();
			System.exit(0);
		}
	}

	@Override
	// update slider with changed age value
	public void update(Observable o, Object arg) {
		js.setValue(aperson.getAge());
		al.setText("Age: " + aperson.getAge());
	}
}
