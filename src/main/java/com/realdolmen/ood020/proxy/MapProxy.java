package com.realdolmen.ood020.proxy;

import java.util.HashMap;

public class MapProxy implements AbstractMap {

	private String fileName;
	private HashMap<String, String> hashtable = new HashMap<String, String>();
	private AbstractMap map;

	public MapProxy(String fileName) {
		this.fileName = fileName;
	}

	public String find(String key) throws Exception {
		if(hashtable.containsKey(key)) {
			return this.get(key);
		}

		String found = getMap(fileName).find(key);
		if(found != null) {
			hashtable.put(key, found);
		}
		return found;
	}

	public void add(String key, String value) throws Exception {
		put(key, value);
		getMap(fileName).add(key, value);

	}

	private String get(String key) {
		return (String) hashtable.get(key);
	}

	private void put(String key, String value) {
		hashtable.put(key, value);
	}

	private AbstractMap getMap(String fileName) {
		if(this.map == null) {
			map = new Map(fileName);
		}
		return map;
	}
}
