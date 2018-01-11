package com.realdolmen.ood020.decorator;

public class Game {
    public static void main(String[] args) {
        Player player = new PlayerImpl();

        Player decorator = new QuestPlayerDecorator(player);
        for(int i=0; i<150; i++) {
            if(player.getLevel() >= 20) {
                decorator = new FlyingPlayerDecorator(player);
            }
            decorator.hit();
            decorator.fish();
            decorator.sell();
            decorator.fly();
        }
    }
}
