package com.realdolmen.ood020.flyweight;

import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

public class UnknownIcon extends AbstractIcon {

	// We make this package-visible so that only the corresponding
	// factory can instantiate us.
	UnknownIcon() {
		super("images/unknown.png");
	}

	public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
		icon.paintIcon(null, g, tx, ty);
		g.drawString(name, tx, ty + H + 15); // title
	}
}
