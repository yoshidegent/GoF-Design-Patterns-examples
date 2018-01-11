package com.realdolmen.ood020.flyweight;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PictureIcon extends AbstractIcon {

	PictureIcon() {
		super("images/picture.png");
	}

	public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
		icon.paintIcon(null, g, tx, ty);
		g.drawString(name, tx, ty + H + 15); // title
	}
}
