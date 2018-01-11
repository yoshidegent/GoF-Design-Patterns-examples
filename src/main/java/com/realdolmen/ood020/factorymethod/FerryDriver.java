package com.realdolmen.ood020.factorymethod;

public class FerryDriver
{
  public static void main(String args[])
  {
    Ferry theFerry = new Ferry(20); 
    FerryFrame fr = new FerryFrame("Marco's Scenic Island Ferries", theFerry);
    fr.setLocation(250, 250);
    fr.setVisible(true);
  }
}
