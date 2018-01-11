package com.realdolmen.ood020.flyweight;

import javax.swing.*;
import java.awt.Graphics;
import java.net.URL;

public abstract class AbstractIcon {
	final int H = 48;
	ImageIcon icon;

	// We make this package-visible so that only the corresponding
	// factory can instantiate us.
	AbstractIcon(String url) {
		URL iconURL = ClassLoader.getSystemResource(url);
		if (iconURL != null) {
			icon = new ImageIcon(iconURL);
		} else {
			System.out.println("Icon " + url  + " not found");
		}
	}

	public abstract void draw(Graphics g, int tx, int ty, String name,
			boolean selected);
}
