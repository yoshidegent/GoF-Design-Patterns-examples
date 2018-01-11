package com.realdolmen.ood020.decorator;

public abstract class PlayerDecorator implements Player {
    private Player player;

    public PlayerDecorator(Player player) {
        this.player = player;
    }

    protected Player getPlayer() {
        return this.player;
    }
}
