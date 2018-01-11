package com.realdolmen.ood020.flyweight;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlyweightDemo extends JPanel implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items;
	private IconFactory factory;
	private final int Top = 10, Left = 10;
	private final int W = 50, H = 30;
	private final int VSpace = 80, HSpace = 70, HCount = 3;
	private String selectedName = "";

	private class Item {
		String type;
		String name;
		AbstractIcon icon;

		Item(String type, String name, AbstractIcon icon) {
			this.type = type;
			this.name = name;
			this.icon = icon;
		}
	}

	public FlyweightDemo() {
		loadItems();
	}

	private void loadItems() {
		// Get the icon factory.
		factory = IconFactory.INSTANCE;

		items = new ArrayList<>();
		items.add(new Item("dir", "Folder1", factory.createIcon("dir")));
		items.add(new Item("dir", "Folder2", factory.createIcon("dir")));
		items.add(new Item("dir", "Folder3", factory.createIcon("dir")));
		items.add(new Item("dir", "Folder4", factory.createIcon("dir")));
		items.add(new Item("dir", "Folder5", factory.createIcon("dir")));
		items.add(new Item("java", "Abc1.java", factory.createIcon("java")));
		items.add(new Item("java", "Abc2.java", factory.createIcon("java")));
		items.add(new Item("pdf", "Pdf1.java", factory.createIcon("pdf")));
		items.add(new Item("pdf", "Pdf2.java", factory.createIcon("pdf")));
		items.add(new Item("txt", "Text1.java", factory.createIcon("txt")));
		items.add(new Item("txt", "Text2.java", factory.createIcon("txt")));
		items.add(new Item("picture", "Picture.png", factory
				.createIcon("picture")));
		items.add(new Item("html", // --> unknown type
				"index.html", factory.createIcon("html")));
	}

	public void paint(Graphics g) {
		super.paint(g);
		// Folder f;
		Item item;
		int j = 0; // count number in row
		int row = Top; // start in upper left
		int x = Left;
		// go through all the items
		for (int i = 0; i < items.size(); i++) {
			// Get next item, and draw its icon and name:
			item = (Item) items.get(i);
			item.icon.draw(g, x, row, item.name, item.name.equals(selectedName));
			// Recalculation of part of the extrinsic state:
			x = x + HSpace; // change to next posn
			j++;
			if (j >= HCount) { // reset for next row
				j = 0;
				row += VSpace;
				x = Left;
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		int j = 0; // count number in row
		int row = Top; // start in upper left
		int x = Left;
		// go through all the items
		for (int i = 0; i < items.size(); i++) {
			// see if this item area contains the mouse
			Rectangle r = new Rectangle(x, row, HSpace, VSpace);
			if (r.contains(e.getX(), e.getY())) {
				selectedName = ((Item) items.get(i)).name;
				this.repaint();
			}
			x = x + HSpace; // change to next posn
			j++;
			if (j >= HCount) { // reset for next row
				j = 0;
				row += VSpace;
				x = Left;
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Flyweight Demo");
		frame.setSize(new Dimension(250, 300));
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		frame.add(jp, BorderLayout.CENTER);
		FlyweightDemo demo = new FlyweightDemo();
		jp.add(demo, BorderLayout.CENTER);
		frame.addMouseMotionListener(demo);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}