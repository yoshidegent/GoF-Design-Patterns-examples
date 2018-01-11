package com.realdolmen.ood020.decorator;

public class PlayerImpl implements Player {

    private int level = 0;
    private int experience = 0;

    @Override
    public void hit() {
        System.out.println("Hit monster!");
    }

    @Override
    public void fish() {
        System.out.println("Fishing...");
    }

    @Override
    public void sell() {
        System.out.println("Sold item.");
    }

    @Override
    public void fly() {
        System.out.println("Flying!");
    }

    @Override
    public void addExperience(int exp) {
        experience += exp;
        if(experience >= 1000) {
            level++;
            System.out.println("LEVEL UP! Current level is " + level);
            experience -= 1000;
        }
    }

    @Override
    public int getLevel() {
        return level;
    }
}
