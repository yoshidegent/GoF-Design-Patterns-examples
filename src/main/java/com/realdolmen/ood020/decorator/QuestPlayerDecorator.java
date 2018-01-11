package com.realdolmen.ood020.decorator;

public class QuestPlayerDecorator extends PlayerDecorator {

    public QuestPlayerDecorator(Player player) {
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
        getPlayer().hit();
        getPlayer().addExperience(20);
    }

    @Override
    public void fly() {
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
