package com.realdolmen.ood020.flyweight;

import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

public class FolderIcon extends AbstractIcon {
	private ImageIcon iconUnsel;

	FolderIcon() {
		super("images/folder_open.png");
		String url_open = "images/folder.png";
		URL iconURL = ClassLoader.getSystemResource(url_open);
		if (iconURL != null) {
			iconUnsel = new ImageIcon(iconURL);
		} else {
			System.out.println("Icon " + url_open  + " not found");
		}
	}

	public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
		if (sel) {
			super.icon.paintIcon(null, g, tx, ty);
		} else {
			iconUnsel.paintIcon(null, g, tx, ty);
		}
		g.drawString(name, tx, ty + H + 15); // title
	}
}
