package com.realdolmen.ood020.decorator;

public class FlyingPlayerDecorator extends PlayerDecorator {
    public FlyingPlayerDecorator(Player player) {
        super(player);
    }

    @Override
    public void hit() {
        getPlayer().hit();
        getPlayer().addExperience(100);
    }

    @Override
    public void fish() {
        getPlayer().fish();
        getPlayer().addExperience(50);
    }

    @Override
    public void sell() {
        getPlayer().sell();
        getPlayer().addExperience(20);
    }

    @Override
    public void fly() {
        getPlayer().fly();
    }

    @Override
    public void addExperience(int exp) {
        getPlayer().addExperience(exp);
    }

    @Override
    public int getLevel() {
        return getPlayer().getLevel();
    }
}
