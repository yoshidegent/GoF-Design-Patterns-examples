package com.realdolmen.ood020.flyweight;

import java.util.HashMap;
import java.util.Map;

public enum IconFactory {
	INSTANCE;

	private Map<String, AbstractIcon> iconmap;

	IconFactory() {
		this.iconmap = new HashMap<>();
	}

	public AbstractIcon createIcon(String key) {
		if(!iconmap.containsKey(key)) {
			AbstractIcon icon;
			switch (key) {
				case "pdf":
					icon = new PdfIcon();
					break;
				case "java":
					icon = new JavaIcon();
					break;
				case "dir":
					icon = new FolderIcon();
					break;
				case "txt":
					icon = new TextIcon();
					break;
				case "picture":
					icon = new PictureIcon();
					break;
				default:
					key = "unknown";
					icon = new UnknownIcon();
					break;
			}
			iconmap.put(key, icon);
		}

		return iconmap.get(key);
	}
}
