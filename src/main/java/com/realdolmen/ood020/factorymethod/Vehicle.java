package com.realdolmen.ood020.factorymethod;

class Vehicle {

	protected int noPassengers;
	protected String regNo;

	public Vehicle(int p, String r) {
		noPassengers = p;
		regNo = r;
	}

	public int getSize() {
		return 1;
	}

	public String getRegNo() {
		return regNo;
	}

	public int getNoPass() {
		return noPassengers;
	}

	public int getCost() {
		return Ferry.VEHICLE_COST + (Ferry.PASSENGER_COST * noPassengers);
	}

}
