package com.realdolmen.ood020.flyweight;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PdfIcon extends AbstractIcon {

	PdfIcon() {
		super("images/pdf.png");
	}

	public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
		icon.paintIcon(null, g, tx, ty);
		g.drawString(name, tx, ty + H + 15); // title
	}
}
